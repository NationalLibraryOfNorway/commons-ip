package org.roda_project.commons_ip2.validator;

import org.roda_project.commons_ip2.mets_v1_12.beans.Mets;
import org.roda_project.commons_ip2.validator.common.InstatiateMets;
import org.roda_project.commons_ip2.validator.common.ZipManager;
import org.roda_project.commons_ip2.validator.component.fileComponent.FileComponentValidator;
import org.roda_project.commons_ip2.validator.component.metsrootComponent.MetsComponentValidator;
import org.roda_project.commons_ip2.validator.component.ValidatorComponent;
import org.roda_project.commons_ip2.validator.constants.Constants;
import org.roda_project.commons_ip2.validator.observer.ProgressValidationLoggerObserver;
import org.roda_project.commons_ip2.validator.observer.ValidationObserver;
import org.roda_project.commons_ip2.validator.reporter.ValidationReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author João Gomes <jgomes@keep.pt>
 */

public class EARKSIPValidator {
  private static final Logger LOGGER = LoggerFactory.getLogger(EARKSIPValidator.class);
  private Path earksipPath;

  private ValidationReporter reporter;
  private ZipManager zipManager;
  private ValidationObserver observer;
  private Mets mets;
  private List<ValidatorComponent> components;

  public EARKSIPValidator(Path earksipPath, Path reportPath) throws JAXBException, IOException, SAXException {
    this.earksipPath = earksipPath.toAbsolutePath().normalize();
    reporter = new ValidationReporter(reportPath.toAbsolutePath().normalize());
    zipManager = new ZipManager();
    observer = new ProgressValidationLoggerObserver();
//    InstatiateMets instatiateMets = new InstatiateMets(zipManager);
//    mets = instatiateMets.instatiateMetsFile(earksipPath);
    setupComponents();
  }

  private  void setupComponents() {
    components = new ArrayList<>();
    ValidatorComponent metsComponent = new MetsComponentValidator(Constants.CSIP_MODULE_NAME_1);
    components.add(metsComponent);
  }

  public boolean validate() {
    observer.notifyValidationStart();
    ValidatorComponent fileComponent = new FileComponentValidator(Constants.CSIP_MODULE_NAME_0);
    fileComponent.setObserver(observer);
    fileComponent.setReporter(reporter);
    fileComponent.setZipManager(zipManager);
    fileComponent.setEARKSIPpath(earksipPath);
    try {
      boolean validFileComponent = fileComponent.validate();
      if(validFileComponent){
        for(ValidatorComponent component : components){
          component.setObserver(observer);
          component.setReporter(reporter);
          component.setZipManager(zipManager);
          component.setEARKSIPpath(earksipPath);
          component.setMets(mets);
          boolean valid = component.validate();
          component.clean();
        }
      }
      if(reporter.getErrors() > 0){
        reporter.componentValidationFinish("INVALID");
      }
      else{
        reporter.componentValidationFinish("VALID");
      }
      observer.notifyIndicators( reporter.getErrors(), reporter.getSuccess(), reporter.getWarnings());
      reporter.close();
      observer.notifyFinishValidation();

    } catch (IOException e){
      LOGGER.error("Could not parse file.", e);
    }
    return true;
  }
}

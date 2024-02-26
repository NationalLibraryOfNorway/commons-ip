/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/commons-ip
 */
package org.roda_project.commons_ip2.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;
import org.roda_project.commons_ip.utils.FileZipEntryInfo;
import org.roda_project.commons_ip.utils.IPException;
import org.roda_project.commons_ip2.mets_v1_12.beans.FileType;
import org.roda_project.commons_ip2.mets_v1_12.beans.Mets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class METSZipEntryInfo extends FileZipEntryInfo {
  private static final Logger LOGGER = LoggerFactory.getLogger(METSZipEntryInfo.class);

  private Mets mets;
  private boolean rootMETS;
  private Map<String, String> checksums;
  private long size;
  private FileType fileType;

  public METSZipEntryInfo(String name, Path filePath, Mets mets, boolean rootMETS, FileType fileType) {
    super(name, filePath);
    this.mets = mets;
    this.rootMETS = rootMETS;
    checksums = new HashMap<>();
    size = 0;
    this.fileType = fileType;
  }

  public Map<String, String> getChecksums() {
    return checksums;
  }

  public void setChecksums(Map<String, String> checksums) {
    this.checksums = checksums;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public FileType getFileType() {
    return fileType;
  }

  public void setFileType(FileType fileType) {
    this.fileType = fileType;
  }

  @Override
  public void prepareEntryforZipping() throws IPException {
    try {
      // Write METS to file
      METSUtils.marshallMETS(mets, getFilePath(), rootMETS);
      setSize(Files.size(getFilePath()));

      if (!rootMETS && fileType != null) {
        // This is a representation METS, and we need to fill the fileType with information
        // The fileType is used for creating the fileSec with references to the representation METS in the root METS file

        // Fill fileType with MimeType, DateCreated and FileSize
        METSUtils.setFileBasicInformation(LOGGER, getFilePath(), fileType);
      }
    } catch (JAXBException | IOException e) {
      throw new IPException("Error marshalling METS", e);
    } catch (InterruptedException e) {
      // do nothing
    }
  }

}

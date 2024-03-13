//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package org.roda_project.commons_ip.mets_v1_11.beans;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * objectType: complexType for interfaceDef and mechanism elements
 * The mechanism and behavior elements point to external objects--an interface definition object or an executable code object respectively--which together constitute a behavior that can be applied to one or more <div> elements in a <structMap>.
 *
 *
 * <p>Java class for objectType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="objectType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attGroup ref="{http://www.loc.gov/METS/}LOCATION"/>
 *       <attGroup ref="{http://www.w3.org/1999/xlink}simpleLink"/>
 *       <attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       <attribute name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objectType")
public class ObjectType {

  @XmlAttribute(name = "ID")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlID
  @XmlSchemaType(name = "ID")
  protected String id;
  @XmlAttribute(name = "LABEL")
  protected String label;
  @XmlAttribute(name = "LOCTYPE", required = true)
  protected String loctype;
  @XmlAttribute(name = "OTHERLOCTYPE")
  protected String otherloctype;
  @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink")
  protected String type;
  @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink")
  @XmlSchemaType(name = "anyURI")
  protected String href;
  @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink")
  protected String role;
  @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink")
  protected String arcrole;
  @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink")
  protected String title;
  @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink")
  protected String show;
  @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink")
  protected String actuate;

  /**
   * Gets the value of the id property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getID() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setID(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the label property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getLABEL() {
    return label;
  }

  /**
   * Sets the value of the label property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setLABEL(String value) {
    this.label = value;
  }

  /**
   * Gets the value of the loctype property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getLOCTYPE() {
    return loctype;
  }

  /**
   * Sets the value of the loctype property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setLOCTYPE(String value) {
    this.loctype = value;
  }

  /**
   * Gets the value of the otherloctype property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getOTHERLOCTYPE() {
    return otherloctype;
  }

  /**
   * Sets the value of the otherloctype property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setOTHERLOCTYPE(String value) {
    this.otherloctype = value;
  }

  /**
   * Gets the value of the type property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getType() {
    if (type == null) {
      return "simple";
    } else {
      return type;
    }
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setType(String value) {
    this.type = value;
  }

  /**
   * Gets the value of the href property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHref() {
    return href;
  }

  /**
   * Sets the value of the href property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHref(String value) {
    this.href = value;
  }

  /**
   * Gets the value of the role property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getRole() {
    return role;
  }

  /**
   * Sets the value of the role property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setRole(String value) {
    this.role = value;
  }

  /**
   * Gets the value of the arcrole property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getArcrole() {
    return arcrole;
  }

  /**
   * Sets the value of the arcrole property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setArcrole(String value) {
    this.arcrole = value;
  }

  /**
   * Gets the value of the title property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the value of the title property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTitle(String value) {
    this.title = value;
  }

  /**
   * Gets the value of the show property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getShow() {
    return show;
  }

  /**
   * Sets the value of the show property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setShow(String value) {
    this.show = value;
  }

  /**
   * Gets the value of the actuate property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getActuate() {
    return actuate;
  }

  /**
   * Sets the value of the actuate property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setActuate(String value) {
    this.actuate = value;
  }

}

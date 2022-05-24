package com.bitc.ajax.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class PharmacyFullDataDto {
  private PharmacyHeaderDto header;
  private PharmacyBodyDto body;

  @XmlElement(name = "header")
  public PharmacyHeaderDto getHeader() {
    return header;
  }

  public void setHeader(PharmacyHeaderDto header) {
    this.header = header;
  }

  @XmlElement(name = "body")
  public PharmacyBodyDto getBody() {
    return body;
  }

  public void setBody(PharmacyBodyDto body) {
    this.body = body;
  }
}

package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class Covid19InfoDto {
  private Covid19InfoHeaderDto header;
  private Covid19InfoBodyDto body;

  @XmlElement(name = "header")
  public Covid19InfoHeaderDto getHeader() {
    return header;
  }

  public void setHeader(Covid19InfoHeaderDto header) {
    this.header = header;
  }

  @XmlElement(name = "body")
  public Covid19InfoBodyDto getBody() {
    return body;
  }

  public void setBody(Covid19InfoBodyDto body) {
    this.body = body;
  }
}

package com.demo.poc.commons.custom.properties.cache;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CacheTemplate implements Serializable {

  private CleaningFrequency cleaningFrequency;
  private long customTtl;
}
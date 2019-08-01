package com.ming.bean;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.core.convert.converter.Converter;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

//进行日期类型的转换
// java.lang.String类型--------> java.util.Date
//public class ConverDate implements Converter<String, Date> {

  public class ConverDate extends PropertyEditorSupport {

      public String parttern = "yyyy-MM-dd";
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
          System.out.println("text = " + text);
          try {
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parttern);
              Date date = simpleDateFormat.parse(text);
              this.setValue(date);
          }catch (Exception ex){
            ex.printStackTrace();
          }
      }
  }

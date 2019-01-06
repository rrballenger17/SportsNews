package com.production.tags;

import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.apache.taglibs.standard.tag.common.fmt.SetLocaleSupport;
import org.apache.taglibs.standard.tag.common.fmt.TimeZoneSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Function;

public class FormatDateTag extends TagSupport
{
	
    public FormatDateTag()
    {
        super();
    }
        
    public void setDateStyle(String style)
    {
        this.timeStyle = style;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    protected String value;
    protected String timeStyle;


    
//                this.pageContext.getOut().print(formatted);
    @Override
    public int doEndTag() throws JspException
    {
    	
    	
    	//Create formatter
    	DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	
    	if(timeStyle.toLowerCase().equals("medium")) {
    		FOMATTER = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

    	}

    	if(timeStyle.toLowerCase().equals("long")) {
    		FOMATTER = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
    	}
    	
    	//Local time instance
    	 LocalDateTime localTime = LocalDateTime.now();
    	 
    	//Get formatted String
    	String localTimeString = FOMATTER.format(localTime);
    	 
       
  
            try {
            	
            	//System.out.println("using printer");
                this.pageContext.getOut().print(localTimeString);
            } catch (IOException e) {
                throw new JspTagException(e.toString(), e);
            }
       

        return Tag.EVAL_PAGE;
    }
	
	
    
    
    
    
    
    
    
    
    
}

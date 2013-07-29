/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.mytag;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Roman
 */
public class DateTagHandler extends BodyTagSupport {

    /**
     * Creates new instance of tag handler
     */
    public DateTagHandler() {
        super();
    }

    private void writeTagBodyContent(JspWriter out, BodyContent bodyContent) throws IOException {
        try {
            
            String oldDate = bodyContent.getString();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldDate);
            String formatedDate = new SimpleDateFormat("dd.MM.yyyy").format(date);
            out.println(formatedDate);
            bodyContent.clearBody();
        } catch (ParseException ex) {
            Logger.getLogger(DateTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            BodyContent bodyCont = getBodyContent();
            JspWriter out = bodyCont.getEnclosingWriter();

            writeTagBodyContent(out, bodyCont);
        } catch (Exception ex) {
            handleBodyContentException(ex);
        }


        return SKIP_BODY;

    }

    /**
     * Handles exception from processing the body content.
     */
    private void handleBodyContentException(Exception ex) throws JspException {
        // Since the doAfterBody method is guarded, place exception handing code here.
        throw new JspException("Error in DateTagHandler tag", ex);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import java.io.File;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Adam
 */
public class pdfLogo {
    private Image img;

    /**
     * Creates a new instance of pdfLogo
     */
    public void preProcessPDF(Object document) throws IOException,BadElementException,DocumentException {
        Document pdf = (Document) document;
        ServletContext servletContex = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContex.getRealPath("");
        System.out.println("logo");
        pdf.open();
        String logo2 = "/images/logotyp.png";
        img = Image.getInstance(logo+logo2);
        img.setAlignment(Image.ALIGN_CENTER);
        pdf.add(img);
        
    }
    public pdfLogo() {
    }
    
}

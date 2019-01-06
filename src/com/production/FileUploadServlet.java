package com.production;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.production.objects.Attachment;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet(
        name = "fileUploadServlet",
        urlPatterns = {"/uploadtest"},
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private boolean downloadAttachment(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    	
    	String param = request.getParameter("attachmentName");
    	
    	if(param == null) {
    		return false;
    	}

    	Attachment attachment = null;
    	
    	for(Attachment a: attachments) {
    		if( a.getName().equals(param) ){
    			attachment = a;
    		}
    	}
    	
    	if(attachment == null)
    	{
    		return false;
    	}
    	
    	response.setHeader("Content-Disposition",
    			"attachment; filename=" + attachment.getName());
    	response.setContentType("application/octet-stream");

    	ServletOutputStream stream = response.getOutputStream();
    	stream.write(attachment.getContents());
    	
    	return true;
   
    }    
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		if(downloadAttachment(request, response)) {
			return;
		}
		
		this.writeHeader(response);
		
        PrintWriter writer = response.getWriter();

        writer.append("<h2>Upload Files</h2>\r\n");
        writer.append("<form method='POST' action='uploadtest' ")
              .append("enctype='multipart/form-data'>\n\n");
        
        //hidden create field
        writer.append("<input type='hidden' name='action' value='create' />\n\n");
        
        // name
        writer.append("Your Name<br/>\n\n");
        writer.append("<input type='text' name='customerName' /><br/><br/>\n\n");
        
        // subject
        writer.append("Subject<br/>\n\n");
        writer.append("<input type='text' name='subject' /><br/><br/>\n\n");
        
        // body
        writer.append("Body<br/>\n\n");
        writer.append("<textarea name='body' rows='5' cols='30'>")
              .append("</textarea><br/><br/>\n\n");
        
        // attachment
        writer.append("<b>Attachments</b><br/>\n\n");
        writer.append("<input type='file' name='file1' /><br/><br/>\n\n");
        writer.append("<input type='submit' value='Submit' />\n\n");
        writer.append("</form>\n\n");
        
        // list attachments
        writer.append("<br/>");
        writer.append("<br/>");
        writer.append("Attachments<br/>");
        for(Attachment a: attachments) {
            writer.append("<a href='uploadtest?attachmentName=" + a.getName() + "' >"+ a.getName() + "</a><br/>");
        }


        
        this.writeFooter(writer);
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        
	}
	
    private Attachment processAttachment(Part filePart)
            throws IOException
    {
    	
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        
        int read;
        final byte[] bytes = new byte[1024];

        while((read = inputStream.read(bytes)) != -1)
        {
            outputStream.write(bytes, 0, read);
        }

        Attachment attachment = new Attachment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }
    
    static List<Attachment> attachments = new ArrayList<Attachment>();
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		Part filePart = request.getPart("file1");
		
        if(filePart != null && filePart.getSize() > 0)
        {
            Attachment attachment = this.processAttachment(filePart);
            
            if(attachment != null) {
            	
            	synchronized(attachments) {
            		attachments.add(attachment);
            	}
                
            }
            
        }
        
        doGet(request, response);

	}
	
	
    private PrintWriter writeHeader(HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("    <head>\r\n")
              .append("        <title></title>\r\n")
              .append("    </head>\r\n")
              .append("    <body>\r\n");

        return writer;
    }

    private void writeFooter(PrintWriter writer)
    {
        writer.append("    </body>\r\n").append("</html>\r\n");
    }

}

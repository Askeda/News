<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.io.*,java.util.*,org.apache.commons.fileupload.FileItem" %>
    <%@page import="org.apache.commons.fileupload.*" %>
    <%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
    <%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String uploadFileName="";
String fileidName="";
boolean isMultipart=ServletFileUpload.isMultipartContent(request);
String uploadFilePath=request.getSession().getServletContext().getRealPath("upload/");
File tempPatchFile=new File("d\\temp\\buffer\\");
if(!tempPatchFile.exists()){
	tempPatchFile.mkdirs();
}
if(isMultipart){
	DiskFileItemFactory factory=new DiskFileItemFactory();
	factory.setSizeThreshold(4096);
	factory.setRepository(tempPatchFile);
	ServletFileUpload upload=new ServletFileUpload(factory);
	upload.setSizeMax(1024*30);
	try{
		List<FileItem> items=upload.parseRequest(request);
		Iterator<FileItem> iter=items.iterator();
		while(iter.hasNext()){
			FileItem item=(FileItem) iter.next();
			if(!item.isFormField()){
				String fileName=item.getName();
			List<String>filType=Arrays.asList("gif","bmp","jpg");
				String ext=fileName.substring(fileName.lastIndexOf(".")+1);
				if(!filType.contains(ext)){
					out.print("上传失败，文件类型只能是gif、bmp、jpg");
					
				}else{
					if(fileName!=null&&!fileName.equals("")){
						File fullFile=new File(item.getName());
						File saveFile=new File(uploadFilePath,fullFile.getName());
						item.write(saveFile);
						uploadFileName=fullFile.getName();
						out.print("上传成功后的文件名是："+uploadFileName+",文件大小是："
						+item.getSize()+"bytes!");
						
					}
				}
				
			}
		}
		}catch(FileUploadBase.SizeLimitExceededException ex){
			out.print("上传失败，文件太大，单个文件的最大限制是："+upload.getSizeMax()+"bytes!");
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
</body>
</html>
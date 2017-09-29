package vn.myclass.core.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by TuanKul on 9/26/2017.
 */
public class UploadUtil {
    private final int maxMemorySize = 1024 * 1024 * 3;//3Mb
    private final int maxRequestSize = 1024 * 1024 * 50;//50Mb

    public Object[] writeOrUpdateFile(HttpServletRequest request, Set<String> titleValue, String path) throws FileUploadException,Exception {//co FileUploadException de hk bi treo may
        ServletContext context = request.getServletContext();
        String address = context.getRealPath("image");
        boolean check = true;
        String fileLocation = null;
        String name = null;
        Map<String, String> mapReturnValue = new HashMap<String, String>();
        // Check that we have a file upload request
        // uploadfile trong servlet su dung apache commons
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart) {
            System.out.printf("have not enctype multipart/form-data");
            check = false;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));//tao ra 1 bo nho tam

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);

        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items) {
            if(!item.isFormField()) {//if bang false thi no biet la dang uploadfile true thi la co textbox,checkbox...
                name = item.getName();
                if(StringUtils.isNotBlank(name)){
                    File uploadFile = new File(address + File.separator + path + File.separator + name);
                    fileLocation = address + File.separator + path + File.separator + name;
                    name = name;
                    boolean isExist = uploadFile.exists();
                    if(isExist) {//neu ton tai se xoa va add moi vao
                        if(uploadFile.delete()) {
                            item.write(uploadFile);
                        }
                        else {
                            check = false;
                        }
                    }
                    else {
                        item.write(uploadFile);
                    }
                }
            }
            else {
                if(titleValue != null) {
                    String nameField = item.getFieldName();//lay name ben jsp nhu la pojo.name
                    String valueField = item.getString();//lay gia tri cua name
                    if(titleValue.contains(nameField)) {
                        mapReturnValue.put(nameField,valueField);
                    }
                }
            }
        } return  new Object[]{check,fileLocation, name, mapReturnValue};
    }
}

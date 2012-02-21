package com.example.junkyard.streamresponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.services.Response;

import java.io.*;

/**
 */
public class XLSStreamResponse implements StreamResponse {
    private InputStream is;
    private String filename = "default";

    public XLSStreamResponse(HSSFWorkbook workbook, String... args) {

        FileOutputStream fout = null;

        try {
            File tmpFile = File.createTempFile("xlsstream", ".xls");
            tmpFile.deleteOnExit();

            fout = new FileOutputStream(tmpFile);
            workbook.write(fout);

            is = new FileInputStream(tmpFile);

        } catch (IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException ioe) {
                    // who cares
                }
            }
        }


        if (args != null) {
            this.filename = args[0];
        }
    }

    public String getContentType() {
        return "application/xls";
    }

    public InputStream getStream() throws IOException {
        return is;
    }

    public void prepareResponse(Response response) {
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".xls");
    }
}

package com.example.junkyard.pages.ExcelColors;

import com.example.junkyard.domain.report.ExcelColorReport;
import com.example.junkyard.streamresponse.XLSStreamResponse;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.OnEvent;

/**
 * Created with IntelliJ IDEA.
 * User: rbaptiste
 * Date: 9/25/12
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExcelColorDemo {

    @OnEvent(value = "createReport")
    StreamResponse createReport() {
        return new XLSStreamResponse(new ExcelColorReport().getWorkbook(), "Excel Color Report");
    }
}

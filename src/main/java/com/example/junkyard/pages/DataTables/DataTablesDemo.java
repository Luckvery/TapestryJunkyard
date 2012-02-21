package com.example.junkyard.pages.DataTables;

import com.example.junkyard.model.Celebrity;
import com.example.junkyard.model.CelebritySource;
import com.example.junkyard.model.IDataSource;
import com.example.junkyard.model.TableInformation;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.BeanModelSource;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/27/12
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Import(stylesheet = {"context:style/dataTables/css/demo_table_jui.css",
                    "context:style/dataTables/css/demo_page.css",
                    "context:style/dataTables/css/demo_table.css",
                    "context:style/dataTables/ColVis/media/css/ColVis.css",
                    "context:style/dataTables/ColReorder/media/css/ColReorder.css",
                    "context:style/dataTables/TableTools/media/css/TableTools.css"})

public class DataTablesDemo {

    @SessionState
    private IDataSource dataSource;
    private Celebrity celebrity;
    private CelebritySource celebritySource;

    @Property
    private Celebrity current;

    public GridDataSource getCelebritySource() {
        if(celebritySource==null)
            celebritySource = new CelebritySource(dataSource);
        return celebritySource;
    }

    public List<Celebrity> getAllCelebrities() {
        System.out.println("Getting all celebrities...");
        return dataSource.getAllCelebrities();
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    @Inject
    private ComponentResources resources;


    @Inject
    private BeanModelSource beanModelSource;

    @SuppressWarnings("unchecked")
    private BeanModel model;

    @SuppressWarnings("unchecked")
    public BeanModel getModel() {
        this.model = beanModelSource.createDisplayModel(Celebrity.class,resources.getMessages());
        this.model.get("firstName").sortable(false);
        return model;
    }

        public TableInformation getInformation(){
        return new TableInformation() {

            public String getTableSummary() {
// TODO Auto-generated method stub
                return "A summary description of table data";
            }

            public String getTableCaption() {
// TODO Auto-generated method stub
                return "The table title";
            }

            public String getTableCSS() {
// TODO Auto-generated method stub
                return "k-data-table";
            }
        };
    }

    public JSONObject getOptions(){

        JSONObject json = new JSONObject("bJQueryUI", "true", "bStateSave", "true", "sDom", "TC<\"clear\">Rlfrtip");
        return json;
    }


}

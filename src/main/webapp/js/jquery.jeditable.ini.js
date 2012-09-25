

(function ($) {

    T5.extendInitializers(function() {

        function init(specs) {
            function init(specs) {
                $('table').addClass( specs.elementClass);
                $('td:first-child').addClass( specs.elementClass);
            }

        }
        $(document).ready(function() {
            $('.edit').editable('http://www.example.com/save.php', {
                indicator : 'Saving...',
                tooltip : 'Click to edit...'
            });
            $('.edit_area').editable('http://www.example.com/save.php', {
                type : 'textarea',
                cancel : 'Cancel',
                submit : 'OK',
                indicator : '<img src="img/indicator.gif"></img>',
                tooltip : 'Click to edit...'
            });
        });
        return {
            editDemo : init
        }
    });
}) (jQuery);



$.add_field_edit_handlers = function(oTable){
    /*
     * Setup up the editable columns.
     * --The table must have an ID.
     * --The table must have a custom attribute of 'editURL' containing the url of
     *   where to send the edit data.
     * --The columns to be edited must have the class 'editable'
     * --The row containing the editable columns must have some sort of
     *   identifying information.
     */
    $('#' + oTable.attr('id') + ' td.editable').editable($(oTable).attr('editURL'), {
        "callback": function( sValue, y ) {
            /*
             * Handle return from the server
             */
            var aPos = $(oTable).dataTable().fnGetPosition( this );
            $(oTable).dataTable().fnUpdate( sValue, aPos[0], aPos[1] );
        },
        "submitdata": function ( value, settings ) {
            /*
             * Sends to the server
             */
            return {
                "row_id": this.parentNode.getAttribute('id'),
                "column": $(oTable).dataTable().fnGetPosition( this )[2]
            };
        }
    });
}
/**
 * Setup a generic editable datatable
 */
$('table.editable').dataTable({
    "bPaginate": false,
    "bLengthChange": false,
    "bFilter": false,
    "bSort": false,
    "bInfo": false,
    "bAutoWidth": false,
    "fnInitComplete" : function(oSettings, json){
        var oTable = this;
        $.add_field_edit_handlers(oTable);
    }
});
/**
 * Add a click event handler to insert the hidden row template in the footer
 * into the tables body. This is sort of a pain in the ass due to the way that
 * the Datatables plugin works. You cant simply add your row. Datatables adds
 * rows by taking an array of cell content, not the cells themselves. This
 * means that our template row's cells lose their classes. So we have to extract
 * the classes and then add them back once Datatables.fnAddData() has added
 * the new row. swright 02-21-2012
 */
$('.addRow').click(function(){
    // Get the ID of the clicked table
    var oTable = $(this).closest('table');
    // Something to hold the template row
    var template = new Array();
    // Something to hold the styles from each cell in the template row
    var td_class = new Array();
    /*
     * Iterate the TDs in the template row. Add the content for each cell to
     * the template array. Add the CSS class for each cell to the td_class array
     */
    $(oTable).find('tfoot tr.template td').each(function(){
        template.push($(this).html());
        if(typeof($(this).attr('class')) != "undefined"){
            td_class.push($(this).attr('class'));
        }
    });
    // Add the template array
    $(oTable).dataTable().fnAddData(template);
    /*
     * Iterate the new row's TDs and add the classes that we saved in the
     * td_class array.
     */
    $(oTable).find('tbody tr:last td').each(function(index, val){
        if(typeof(td_class[index]) != "undefined"){
            $(val).attr('class', td_class[index]);
        }
    });
    // Added the field edit handlers
    $.add_field_edit_handlers(oTable);
});
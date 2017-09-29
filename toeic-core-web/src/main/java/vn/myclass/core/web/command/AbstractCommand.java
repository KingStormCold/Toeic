package vn.myclass.core.web.command;

import java.util.List;

/**
 * Created by TuanKul on 9/18/2017.
 */
public class AbstractCommand<T> {
    protected T pojo;
    private String crudaction;
    private List<T> listResult;//displaytable can tra ve 1 danh sach listResult
    private String tableId = "tableList";//lay id cua displaytable khi displaytable tu sinh ra
    private int maxPageItems = 5;//tong so item tren 1 trang
    private int totalItems = 0;//tong so item tra ve trong list do
    private int firstItem = 0;//vi tri bat dau cua row trong table de lay dung du lieu
    private String sortExpression;//
    private String sortDirection;
    private String[] checkList;//xoa 1 lan nhieu item,de chua id
    private String messageResponse;//tra ve thong bao
    private int page = 1;//de start len thi no se nam o trang 1
    private String urlType;

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }

    public String getSortExpression() {
        return sortExpression;
    }

    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String[] getCheckList() {
        return checkList;
    }

    public void setCheckList(String[] checkList) {
        this.checkList = checkList;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
}

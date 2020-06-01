package com.i520java.springcloud.i520java.util;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @ClassName:I520IavaPage
 * @author:金格[JIN_GE]
 * @date: 2020-04-29 
 * @description 此模板由【Jin ge】提供!
 *              更多教程请访问 https://www.520java.com 交流学习
 */
public class I520JavaPage<T> implements Serializable {
    private static final long serialVersionUID = -20504583157702495L;
    private Integer           count;       //总数据行
    private Integer           pageSize;    //页面数据行数
    private Integer           pageIndex;   //当前页码
    private Integer           totalPage;   //总页页数
    private Integer           pageNum;     //页码数量
    private List<Integer> pageNumList; //页码集合
    private Boolean       isPageNum;   //是否计算页码
    private T      data;  //带回的数据

    public I520JavaPage(){
        this.count=0;
        this.pageSize=0;
        this.pageIndex=1;
        this.totalPage=0;
        this.isPageNum=false;
    }

    public I520JavaPage(Integer pageIndex,Integer pageSize){
        this.count=0;
        this.pageSize=pageSize;
        this.pageIndex=pageIndex;
        this.totalPage=0;
        this.isPageNum=false;
    }

    public I520JavaPage(Integer pageIndex,Integer pageSize,Integer pageNum){
        this.count=0;
        this.pageSize=pageSize;
        this.pageIndex=pageIndex;
        this.totalPage=0;
        this.pageNum=pageNum;
        this.pageNumList=new ArrayList<Integer>();
        this.isPageNum=true;
    }

    /**
     * 计算页码
     * @Author 金格[JIN_GE]
     * @description 此模板由【Jin ge】提供!
     *              更多教程请访问 https://www.520java.com 交流学习
     **/
    public void countPageNum(){
        this.pageNumList=new ArrayList<Integer>();
        if(this.getTotalPage()<=this.getPageNum()){
            for(int i=1;i<=this.getTotalPage();i++){
                this.pageNumList.add(i);
            }
        }else{
            int adjustIndex=0;
            if(this.getPageIndex()==1){
                adjustIndex=1;
            }else if(this.getPageIndex()==this.getTotalPage()){
                adjustIndex=this.getTotalPage()-(this.getPageNum()-1);
            }else{
                int middle=(int)(this.getPageNum()/2);
                if(this.getPageIndex()<this.getPageNum()){
                    adjustIndex=1;
                }else if(this.getPageIndex()>(this.getTotalPage()-this.getPageNum())){
                    adjustIndex=this.getTotalPage()-(this.getPageNum()-1);
                }else{
                    adjustIndex=this.getPageIndex()-middle;
                }
            }
            for(int i=adjustIndex;i<(adjustIndex+this.getPageNum());i++){
                this.pageNumList.add(i);
            }
        }
    }



    public Integer getCount() {
        return count==0?1:count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageIndex() {
        if(pageIndex!=null){
            if(pageIndex<1){
                pageIndex=1;
            }
            if(getTotalPage()>0){
                if(pageIndex>getTotalPage()){
                    pageIndex=getTotalPage();
                }
            }
        }
        return pageIndex;
    }
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
    public Integer getTotalPage() {

        if(getCount()!=null&&getPageSize()!=null){
            totalPage= getCount()%getPageSize()==0?getCount()/getPageSize():getCount()/getPageSize()+1;
            return totalPage;
        }
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        this.isPageNum=true;
    }
    public List<Integer> getPageNumList() {
        return pageNumList;
    }
    public void setPageNumList(List<Integer> pageNumList) {
        this.pageNumList = pageNumList;
    }
    public Boolean isPageNum() {
        return isPageNum;
    }
    public void setPageNum(Boolean isPageNum) {
        this.isPageNum = isPageNum;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
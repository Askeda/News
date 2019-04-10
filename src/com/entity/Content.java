package com.entity;



public class Content {
private int nid;
private int ntid;
private String ntitle;//���ű���
private String nauthor;//����
private String ncreateDate;//ʱ��
private String npicpath;//ͼƬ·��
private String ncontent;//����
private String nmodifyDate;//�޸ĵ�ʱ��
private String nsummary;//��ע
public Content(){}
public Content(int nid,int ntid,String ntitle,String nauthor,String ncreateDate,
		String npicpath,String ncontent,String nmodifyDate,String nsummary){
	this.nauthor=nauthor;
	this.nid=nid;
	this.ncontent=ncontent;
	this.ncreateDate=ncreateDate;
	this.nmodifyDate=nmodifyDate;
	this.npicpath=npicpath;
	this.ntid=ntid;
	this.ntitle=ntitle;
	this.nsummary=nsummary;
}
public Content(String ntitle,String nauthor,String ncontent,String nsummary){
	this.ntitle=ntitle;
	this.nauthor=nauthor;
	this.ncontent=ncontent;
	this.nsummary=nsummary;
}
public Content(int nid){
	this.nid=nid;
}
public Content(int nid,String ntitle){
	this.nid=nid;
	this.ntitle=ntitle;
}
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public int getNtid() {
	return ntid;
}
public void setNtid(int ntid) {
	this.ntid = ntid;
}
public String getNtitle() {
	return ntitle;
}
public void setNtitle(String ntitle) {
	this.ntitle = ntitle;
}
public String getNauthor() {
	return nauthor;
}
public void setNauthor(String nauthor) {
	this.nauthor = nauthor;
}
public String getNcreateDate() {
	return ncreateDate;
}
public void setNcreateDate(String ncreateDate) {
	this.ncreateDate = ncreateDate;
}
public String getNpicpath() {
	return npicpath;
}
public void setNpicpath(String npicpath) {
	this.npicpath = npicpath;
}
public String getNcontent() {
	return ncontent;
}
public void setNcontent(String ncontent) {
	this.ncontent = ncontent;
}
public String getNmodifyDate() {
	return nmodifyDate;
}
public void setNmodifyDate(String nmodifyDate) {
	this.nmodifyDate = nmodifyDate;
}
public String getNsummary() {
	return nsummary;
}
public void setNsummary(String nsummary) {
	this.nsummary = nsummary;
}
@Override
public String toString() {
	return "Content [nid=" + nid + ", ntid=" + ntid + ", ntitle=" + ntitle
			+ ", nauthor=" + nauthor + ", ncreateDate=" + ncreateDate
			+ ", npicpath=" + npicpath + ", ncontent=" + ncontent
			+ ", nmodifyDate=" + nmodifyDate + ", nsummary=" + nsummary + "]";
}

}

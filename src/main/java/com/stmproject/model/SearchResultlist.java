package com.stmproject.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class SearchResultlist {

	public SearchResultlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int rowIndex;

	private Integer no;

	private String stmNo;

	private String stmVersion;

	private String linkDestination;

	private String textShortJP;

	private String textShortEN;

	private String pdfFile;

	private String wordFile;
	
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String draftingDate;
	
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String startDraftDate;
	
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String endDraftDate;
	
	private String oldSTMNumber;

	private String remarks1;

	private String note2;

	private String note3;

	private String creator_sso_id;

	private byte is_deleted;
	
	private String finalDrafterName;
	
	public SearchResultlist(int rowIndex, Integer no, String stmNo, String stmVersion, String linkDestination,
			String textShortJP, String textShortEN, String pdfFile, String wordFile, String draftingDate,
			String startDraftDate, String endDraftDate, String oldSTMNumber, String remarks1, String note2, String note3,
			String creator_sso_id, byte is_deleted, String finalDrafterName) {
		super();
		this.rowIndex = rowIndex;
		this.no = no;
		this.stmNo = stmNo;
		this.stmVersion = stmVersion;
		this.linkDestination = linkDestination;
		this.textShortJP = textShortJP;
		this.textShortEN = textShortEN;
		this.pdfFile = pdfFile;
		this.wordFile = wordFile;
		this.draftingDate = draftingDate;
		this.startDraftDate = startDraftDate;
		this.endDraftDate = endDraftDate;
		this.oldSTMNumber = oldSTMNumber;
		this.remarks1 = remarks1;
		this.note2 = note2;
		this.note3 = note3;
		this.creator_sso_id = creator_sso_id;
		this.is_deleted = is_deleted;
		this.finalDrafterName = finalDrafterName;
	}

	public String getTextShortJP() {
		return textShortJP;
	}

	public void setTextShortJP(String textShortJP) {
		this.textShortJP = textShortJP;
	}

	public String getTextShortEN() {
		return textShortEN;
	}

	public void setTextShortEN(String textShortEN) {
		this.textShortEN = textShortEN;
	}

	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}

	public String getWordFile() {
		return wordFile;
	}

	public void setWordFile(String wordFile) {
		this.wordFile = wordFile;
	}

	public String getDraftingDate() {
		return draftingDate;
	}

	public void setDraftingDate(String draftingDate) {
		this.draftingDate = draftingDate;
	}
	
	public String getStartDraftDate() {
		return startDraftDate;
	}

	public void setStartDraftDate(String startDraftDate) {
		this.startDraftDate = startDraftDate;
	}

	public String getEndDraftDate() {
		return endDraftDate;
	}

	public void setEndDraftDate(String endDraftDate) {
		this.endDraftDate = endDraftDate;
	}

	public String getFinalDrafterName() {
		return finalDrafterName;
	}

	public void setFinalDrafterName(String finalDrafterName) {
		this.finalDrafterName = finalDrafterName;
	}
	public String getOldSTMNumber() {
		return oldSTMNumber;
	}

	public void setOldSTMNumber(String oldSTMNumber) {
		this.oldSTMNumber = oldSTMNumber;
	}

	public String getStmNo() {
		return stmNo;
	}

	public void setStmNo(String stmNo) {
		this.stmNo = stmNo;
	}

	
	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getStmVersion() {
		return stmVersion;
	}

	public String getLinkDestination() {
		return linkDestination;
	}

	public void setLinkDestination(String linkDestination) {
		this.linkDestination = linkDestination;
	}

	public void setStmVersion(String stmVersion) {
		this.stmVersion = stmVersion;
	}
	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getCreator_sso_id() {
		return creator_sso_id;
	}

	public void setCreator_sso_id(String creator_sso_id) {
		this.creator_sso_id = creator_sso_id;
	}

	public byte getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(byte is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "SearchResultlist [rowIndex=" + rowIndex + ", no=" + no + ", stmNo=" + stmNo + ", stmVersion="
				+ stmVersion + ", linkDestination=" + linkDestination + ", textShortJP=" + textShortJP
				+ ", textShortEN=" + textShortEN + ", pdfFile=" + pdfFile + ", wordFile=" + wordFile + ", draftingDate="
				+ draftingDate + ", startDraftDate=" + startDraftDate + ", endDraftDate=" + endDraftDate
				+ ", oldSTMNumber=" + oldSTMNumber + ", remarks1=" + remarks1 + ", note2=" + note2 + ", note3=" + note3
				+ ", creator_sso_id=" + creator_sso_id + ", is_deleted=" + is_deleted + ", finalDrafterName="
				+ finalDrafterName + "]";
	}
	
	

}

package com.stmproject.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.stmproject.model.SearchResultlist;
import com.stmproject.model.M_User;
import com.stmproject.model.STM;
import com.stmproject.repository.S_UserRepository;
import com.stmproject.service.S_UserService;

@Service
public class S_UserServiceImpl implements S_UserService {

	@Autowired
	private EntityManager entManager;
	@Autowired
	private S_UserRepository sUserRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<SearchResultlist> getAllValues() {

		List<STM> stms = sUserRepo.findAllValues();
		List<SearchResultlist> daoList = new ArrayList<>();
		int i = 1;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		for (STM ent : stms) {
			SearchResultlist sDao = new SearchResultlist();
			sDao = modelMapper.map(ent, SearchResultlist.class);
			if (ent.getDraftingDate() != null) {
				String date = sd.format(ent.getDraftingDate());
				sDao.setDraftingDate(date);
			}
			if (ent.getLinkDestination() == null) {
				sDao.setLinkDestination("NULL");
			} else if (ent.getLinkDestination().isBlank() || ent.getLinkDestination().isEmpty()) {
				sDao.setLinkDestination("NULL");
			}
			if (ent.getTextShortJP() == null) {
				sDao.setTextShortJP("NULL");
			} else if (ent.getTextShortJP().isBlank() || ent.getTextShortJP().isEmpty()) {
				sDao.setTextShortJP("NULL");
			}

			if (ent.getTextShortEN() == null) {
				sDao.setTextShortEN("NULL");
			} else if (ent.getTextShortEN().isBlank() || ent.getTextShortEN().isEmpty()) {
				sDao.setTextShortEN("NULL");
			}
			if (ent.getPdfFile() == null) {
				sDao.setPdfFile("NULL");
			} else if (ent.getPdfFile().isBlank() || ent.getPdfFile().isEmpty()) {
				sDao.setPdfFile("NULL");
			}
			if (ent.getWordFile() == null) {
				sDao.setWordFile("NULL");
			} else if (ent.getWordFile().isBlank() || ent.getWordFile().isEmpty()) {
				sDao.setWordFile("NULL");
			}
			if (ent.getOldSTMNumber() == null) {
				sDao.setOldSTMNumber("NULL");
			} else if (ent.getOldSTMNumber().isBlank() || ent.getOldSTMNumber().isEmpty()) {
				sDao.setOldSTMNumber("NULL");
			}
			if (ent.getNote2() == null) {
				sDao.setNote2("NULL");
			} else if (ent.getNote2().isBlank() || ent.getNote2().isEmpty()) {
				sDao.setNote2("NULL");
			}
			if (ent.getNote3() == null) {
				sDao.setNote3("NULL");
			} else if (ent.getNote3().isBlank() || ent.getNote3().isEmpty()) {
				sDao.setNote3("NULL");
			}
			if (ent.getRemarks1() == null) {
				sDao.setRemarks1("NULL");
			} else if (ent.getRemarks1().isBlank() || ent.getRemarks1().isEmpty()) {
				sDao.setRemarks1("NULL");
			}
			sDao.setRowIndex(i++);
			daoList.add(sDao);
		}
		return daoList;
	}

	@Override
	public List<SearchResultlist> getValuesBySetValue(SearchResultlist dao) {
		String strQuery = "Select * from dbo.STM where STM_No like N'%" + dao.getStmNo() + "%'";
		StringBuffer sb = new StringBuffer();

		sb.append(strQuery);
		if (!ObjectUtils.isEmpty(dao.getStmVersion())) {
			sb.append(" and STM_Version like '" + dao.getStmVersion() + "'");
		}

		if (!ObjectUtils.isEmpty(dao.getLinkDestination())) {
			sb.append(" and Link_Destination like N'%" + dao.getLinkDestination() + "'");
		}

		if (!ObjectUtils.isEmpty(dao.getTextShortJP())) {
		    sb.append(" and Text_Short_JP COLLATE Japanese_CI_AS LIKE N'%" + dao.getTextShortJP() + "%'");
		}
		if (!ObjectUtils.isEmpty(dao.getTextShortEN())) {
			sb.append(" and Text_Short_EN like '" + dao.getTextShortEN() + "'");
		}
		if (!ObjectUtils.isEmpty(dao.getFinalDrafterName())) {
			sb.append(" and Final_Drafter_Name like N'%" + dao.getFinalDrafterName() + "%'");
		}
		if (!ObjectUtils.isEmpty(dao.getOldSTMNumber())) {
			sb.append(" and Old_STM_Number like N'" + dao.getOldSTMNumber() + "'");
		}
		if (!ObjectUtils.isEmpty(dao.getStartDraftDate())) {
			sb.append(" and drafting_date >= '" + dao.getStartDraftDate() + "'");
		}
		if (!ObjectUtils.isEmpty(dao.getEndDraftDate())) {
			sb.append(" and drafting_date <= '" + dao.getEndDraftDate() + "'");
		}
		sb.append(" and is_deleted='0' ");
		sb.append(" ORDER BY no ");

		String q = sb.toString();
		System.out.println("Query is : " + q);

		Query query = (Query) entManager.createNativeQuery(q, STM.class);

		List<STM> list = query.getResultList();
		List<SearchResultlist> daoList = new ArrayList<>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		int i = 1;
		for (STM ent : list) {
			SearchResultlist sDao = new SearchResultlist();
			sDao = modelMapper.map(ent, SearchResultlist.class);
			if (ent.getDraftingDate() != null) {
				String date = sd.format(ent.getDraftingDate());
				sDao.setDraftingDate(date);
			}
			if (ent.getLinkDestination() == null) {
				sDao.setLinkDestination("NULL");
			} else if (ent.getLinkDestination().isBlank() || ent.getLinkDestination().isEmpty()) {
				sDao.setLinkDestination("NULL");
			}
			if (ent.getTextShortJP() == null) {
				sDao.setTextShortJP("NULL");
			} else if (ent.getTextShortJP().isBlank() || ent.getTextShortJP().isEmpty()) {
				sDao.setTextShortJP("NULL");
			}

			if (ent.getTextShortEN() == null) {
				sDao.setTextShortEN("NULL");
			} else if (ent.getTextShortEN().isBlank() || ent.getTextShortEN().isEmpty()) {
				sDao.setTextShortEN("NULL");
			}
			if (ent.getPdfFile() == null) {
				sDao.setPdfFile("NULL");
			} else if (ent.getPdfFile().isBlank() || ent.getPdfFile().isEmpty()) {
				sDao.setPdfFile("NULL");
			}
			if (ent.getWordFile() == null) {
				sDao.setWordFile("NULL");
			} else if (ent.getWordFile().isBlank() || ent.getWordFile().isEmpty()) {
				sDao.setWordFile("NULL");
			}
			if (ent.getOldSTMNumber() == null) {
				sDao.setOldSTMNumber("NULL");
			} else if (ent.getOldSTMNumber().isBlank() || ent.getOldSTMNumber().isEmpty()) {
				sDao.setOldSTMNumber("NULL");
			}
			if (ent.getNote2() == null) {
				sDao.setNote2("NULL");
			} else if (ent.getNote2().isBlank() || ent.getNote2().isEmpty()) {
				sDao.setNote2("NULL");
			}
			if (ent.getNote3() == null) {
				sDao.setNote3("NULL");
			} else if (ent.getNote3().isBlank() || ent.getNote3().isEmpty()) {
				sDao.setNote3("NULL");
			}
			if (ent.getRemarks1() == null) {
				sDao.setRemarks1("NULL");
			} else if (ent.getRemarks1().isBlank() || ent.getRemarks1().isEmpty()) {
				sDao.setRemarks1("NULL");
			}
			sDao.setRowIndex(i++);
			daoList.add(sDao);
		}
		return daoList;
	}

	@Override
	public boolean isAdminLogin(String userId) {
		String strQuery = "Select * from dbo.m_user where sso_id = N'" + userId + "'";

		Query query = (Query) entManager.createNativeQuery(strQuery, M_User.class);
		List<M_User> list = query.getResultList();
		for (M_User ent : list) {
			if (ent.getUser_Type().equals('A')) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public SearchResultlist setEmptyForNullValues(SearchResultlist modifyUser) {
		if (modifyUser.getLinkDestination() == "NULL") {
			modifyUser.setLinkDestination(" ");
		}
		if (modifyUser.getTextShortJP() == "NULL") {
			modifyUser.setTextShortJP(" ");
		}
		if (modifyUser.getTextShortEN() == "NULL") {
			modifyUser.setTextShortEN(" ");
		}
		if (modifyUser.getPdfFile() == "NULL") {
			modifyUser.setPdfFile(" ");
		}
		if (modifyUser.getWordFile() == "NULL") {
			modifyUser.setWordFile(" ");
		}
		if (modifyUser.getOldSTMNumber() == "NULL") {
			modifyUser.setOldSTMNumber(" ");
		}
		if (modifyUser.getRemarks1() == "NULL") {
			modifyUser.setRemarks1(" ");
		}
		if (modifyUser.getNote2() == "NULL") {
			modifyUser.setNote2(" ");
		}
		if (modifyUser.getNote3() == "NULL") {
			modifyUser.setNote3(" ");
		}
		return modifyUser;
	}

	@Override
	public SearchResultlist findBySTMNo(String stmNo) {
		String strQuery = "Select * from dbo.STM where stm_no='" + stmNo + "' and is_deleted='"+0+"';";

		Query query = (Query) entManager.createNativeQuery(strQuery, STM.class);
		List<STM> list = query.getResultList();
		SearchResultlist sDao = new SearchResultlist();
		if(list.size()>0)
		{
		for(STM ent:list)
		{
			sDao = modelMapper.map(ent, SearchResultlist.class);
			break;
		}
		}
		else
		{
			return null;
		}
		return sDao;
	}

}
package services;

import java.util.List;

import dao.CCERankDAO;
import dao.CCEScoreDAO;
import model.CCERank;
import model.CCEScore;

public class AboutSvc {
	CCERankDAO cr = new CCERankDAO();
	CCEScoreDAO cs = new CCEScoreDAO();
	
	public List<CCERank> getCCERank(){
		return cr.getCCERank();
	}
	public List<CCEScore> getCCEScore(){
		return cs.getCCEScore();
	}
	
}

package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.OneWayPageUI;
import utility.Logs;

public class OneWayPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public OneWayPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void ClickOnOneWay() {
		log = loggerUtil.createLog("OneWayPage.java");
		try {
			helper.actionClick(OneWayPageUI.oneway);
			log.debug("Clicked on OneWayPage under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on OneWayPage under service section");
		}
	}

	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	public void SelectAgra() {
		try {
			helper.applicationWait(5000);
			helper.clickButton(OneWayPageUI.agra);
			log.debug("Dropdown clicked");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot click Dropdown");
		}
	}

	public void SelectPlace() {
		try {
			helper.actionClick(OneWayPageUI.place);
			log.debug("Agra to Shikohabad one-way-cabs selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select");
		}
	}

	public void ValidatePage(String ExpectedTitle) {
		try {
			helper.applicationWait(5000);
			String ActualTitle = helper.getTitle();
			if (ActualTitle.contains(ExpectedTitle)) {
				log.info("Title Validated : " + ActualTitle);
			} else {
				log.info("Title Validated Failed : " + ActualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate");
		}
	}
}

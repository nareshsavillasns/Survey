package com.survey.app.job.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SurveyUtil {
	public static Iterable<CSVRecord> getrecords(Reader in) throws IOException {
		return  CSVFormat.RFC4180.withHeader("SubmissionDate","starttime","endtime","username","duration","caseid","textaudit","comments",
			"audio1","District","Block","Identification2_1","Identification2_2","Village","ward","Identification3_1","Identification3_2",
			"Identification3_3","Identification3_4","HouseholdRel","Identification4_1","Identification4_2","Identification4_3","Identification4_4",
			"above_18","sign_inv1","participatemore18","sign_inv2","participateless18","Q100","Q101","Q101a","Q101a_OE","Q102","Q102_OE","Q103",
			"Q103_OE","Q104","dummy_1","Q105Mat1_1","Q105Mat1_2","Q105Mat1_3","Q105Mat1_4","Q105Mat1_5","Q105Mat1_6","Q105Mat1_7","Q105Mat1_8",
			"Q105Mat1_9","Q105Mat1_10","Q105Mat1_11","Q105Mat1_12","Q105Mat1_13","Q105Mat2_1","Q105Mat2_2","Q105Mat2_5","Q105Mat2_6","Q105Mat2_7",
			"Q105Mat2_8","Q105Mat2_9","Q105Mat2_11","Q105Mat2_12","Q105Mat2_13","Q105Mat2_14","Q105Mat2_15","Q105Mat2_16","Q105Mat2_17","Q105Mat2_18",
			"Q105a","Q105a_OE","Q105b","Q105c","Q105c_OE","Q105d","Q105d_OE","Q106","Q106a","Q107_CODE","Q108","Q109","Q109a","Q110","Q111","Q112",
			"Q113","Q114","Q115","Q116","Q116_OE","Q116a","Q116a_OE","Q116b","Q117","Q117a","Q117b","dummy_1_2","Q118_1","Q118_2","Q118_3","Q119",
			"Q120","Q121_1","Q121_2","Q121_3","Q122_1","Q122_2","Q122_3","Q201","Q202","Q203","Q203a","Q204","Q204a","Q300","Q300a","Q301_1","Q301_2",
			"Q301_3","Q301_4","Q301_5","Q302_1","Q302_2","Q303","Q304","Q305_1","Q305_2","Q306","Q307_1","Q307_2","Q308","Q309_1","Q309_2","Q310_1",
			"Q310_2","Q310_3","Q311","Q312","g_3_1_3_1_count","child1","child2","Q320","Q321","Q322","Q323","Q324","Q325","Q326","Q327","Q328",
			"Q328_OE","dummy_3_1_5_2","Q329_1","Q329_2","Q329_3","Q330","Q331","Q331_11_OE","Q331_14_OE","Q332","Q332a","Q332b","dummy_3_1_5_3",
			"Q332c_1","Q332c_2","Q332c_3","Q332d","Q332e","Q332e_11_OE","Q332e_14_OE","Q333","Q334","Q335","Q335_days","Q335_months","Q335_years",
			"Q336","Q337","Q338","Q338a","dummy_3_1_6","Q339e1","Q339e2","Q339e3","Q339e4","dummy_3_1_8","Q340d1","Q340d2","Q400","Q400a","Q400a_OE",
			"g_4_1_count","method_used","Q403a","Q403b","Q403c","Q403d","Q403d_OE","Q403e_years","Q403e_months","Q403f","Q404","Q405a","Q405b","Q406",
			"Q407","Q408","Q408_OE","Q409","Q410","Q411","Q412","Q413","Q414","Q414_OE","name_method","Q414a","Q414b","dummy_4_4","Q414c_1","Q414c_2",
			"Q414c_3","Q414c_4","Q414c_5","Q414c_6","Q415_months","Q415_years","Q416","Q417","Q418_months","Q418_years","Q419_months","Q419_years",
			"Q420","Q420_oth","Q420a","Q420b","Q421","Q421a","Q422","Q423","Q424","Q425","Q425_OE","Q427_sons","Q427_daughters","Q428","Q428a","Q429a",
			"Q429a_OE","Q429b","Q430","Q431_days","Q431_hours","Q432","Q433","Q433a","Q434","Q434a","Q434b","Q434c","Q435","Q435_a","Q435_b","Q435_c",
			"Q435_d","Q435_e","Q435_f","Q435_g","Q435_h","Q435_conf","Q436","Q437","Q438","Q438_OE","Q438a","Q439","Q439_OE","Q440","Q440_a","Q440_b",
			"Q440_c","Q440_d","Q440_e","Q440_f","Q440_g","Q441","Q442","Q443","Q443_OE","Q443a","Q444","Q444_OE","g_4_10_1_count","Q444c","Q444d",
			"Q445","Q445_a","Q445_b","Q445_c","Q445_d","Q446","Q447","Q448","Q448_OE","Q449","Q449a","Q450","Q450_OE","Q451","Q452","Q453","Q454",
			"Q454_OE","Q455","Q455_OE","Q456","Q456a","Q457","Q458","Q459","Q460","Q461","Q461_OE","Q462","Q463","Q464","Q464_OE","Q465","Q466","Q467",
			"Q468","Q468a","Q468a_days","Q468a_weeks","Q468a_months","Q469","Q470","Q470_OE","Q471","Q471_days","Q471_weeks","Q471_months","Q472",
			"Q473","Q473_days","Q473_weeks","Q473_months","Q474","Q474_OE","Q475","Q475_OE","Q476","Q477","Q477_OE","Q478","Q479","Q480","Q480_OE",
			"Q481","Q482","Q483","Q483_OE","Q484","Q501","Q502","Q502_OE","Q502_months","Q502_years","Q503","Q504","Q504_OE","Q504_months",
			"Q504_years","Q505","Q505_OE","Q506","Q506_OE","Q507","Q508","Q509","Q510","Q510a","Q511","Q511a","Q512","Q512a","Q513","Q513a","Q514",
			"Q514a","Q515","Q516","Q517_boys","Q517_girls","Q517_either","Q518_boys","Q518_girls","Q518_either","Q519","Q601","Q602","Q603","Q604",
			"Q605","Q605_OE","Q606","Q606a","Q606b","dummy_6_1","Q607_1","Q607_2","Q607_3","Q607_4","Q607a","Q607b","Q607b_1","Q607b_2","Q607b_3",
			"Q607b_4","Q608","Q609","Q610","dummy_6_2","Q611_1","Q611_2","Q611_3","Q612","Q613","Q614","Q615","Q616","Q617","Q617a","Q617b","Q617b_OE",
			"Q617c","Q617d","Q617e","Q617f","Q618","Q619","Q619_OE","Q620","Q620_OE","Q620a","Q620a_days","Q620a_weeks","Q620a_months","Q621","Q622",
			"Q622a","Q622a_days","Q622a_weeks","Q622a_months","Q701","Q702","Q703","Q704","Q705","Q706","Q707","g_7_1_count","dummy_7_2","Q710_1",
			"Q710_2","Q710_3","Q710_4","dummy_7_3","Q711_1","Q711_2","Q711_3","Q711_4","Q801","Q802","Q803","Q804","Q805","Q806","Q807","dummy_8_2",
			"Q808_1","Q808_2","Q808_3","Q808_4","Q808_5","dummy_8_1_3","Q809_1","Q809_2","Q809_3","Q809_4","dummy_8_1_4","Q810","Q811","Q812","Q813",
			"Q814","Q815","Q816","dummy_8_3_1","Q817_1","Q817_2","Q817_3","Q817_4","Q817_5","Q817_5_OE","Q817_add","Q818","Q819","Q820","dummy_8_4_1",
			"Q820a_1","Q820a_2","Q820a_3","Q820a_4","Q820a_5","Q820a_6","Q820a_add","Q821","Q822","Q822a","Q823","Q824","Q825","Q825a","Q830","Q831",
			"Q832","Q833","Q834","Q835","Q836","Q837","Q838","Q901","Q901a","Q901a_OE","Q902","Q903","Q904","Q904a","Q904b","Q904b_OE","dummy_9_2",
			"Q905_1","Q905_2","Q905_3","Q905_4","Q905_4_OE","Q906","Q907","Q907a","Q907b","Q907b_OE","Q908","Q909","Q910","Q911","Q912a","Q912b",
			"Q913a","Q913b","Q914","dummy_9_5","Q915_1","Q915_2","Q915_3","Q915_4","Q915_5","Q915_6","Q915_7","Q915_8","Q915_9","Q915_10","Q915_11",
			"Q915_12","Q915_13","Q915_14","Q916","Q917","Q918","Q919","Q920","inv_note","N1","N2","N3","N4","N5","N6","result_status","reason_refusal",
			"instanceID","formdef_version","formdef_id","review_quality","KEY","index_3_1","Q313_1","Q314_1","Q315_1","Q316month_1","Q316year_1",
			"Q317_1","Q318_1","prev_name_1","index4_1_1","index4_1_2","index4_1_3","index4_1_4","index4_1_5","index4_1_6","index4_1_7","index4_1_8",
			"index4_1_9","index4_1_10","index4_1_11","index4_1_12","method_1","method_2","method_3","method_4","method_5","method_6","method_7",
			"method_8","method_9","method_10","method_11","method_12","Q401_1","Q401_2","Q401_3","Q401_4","Q401_5","Q401_6","Q401_7","Q401_8",
			"Q401_9","Q401_10","Q401_11","Q401_12","Q402_1","Q402_2","Q402_3","Q402_4","Q402_5","Q402_6","Q402_7","Q402_8","Q403_1","Q403_2","Q403_3",
			"Q403_4","Q403_5","Q403_6","Q403_7","Q403_8","Q403_9","Q403_10","Q403_11","Q403_12","cal1_1","cal1_2","cal1_3","cal1_4","cal1_5","cal1_6",
			"cal1_7","cal1_8","cal1_9","cal1_10","cal1_11","cal1_12","index7_1_1","index7_1_2","index7_1_3","index7_1_4","index7_1_5","index7_1_6",
			"index7_1_7","index7_1_8","index7_1_9","index7_1_10","index7_1_11","index7_1_12","cal_7_1","cal_7_2","cal_7_3","cal_7_4","cal_7_5",
			"cal_7_6","cal_7_7","cal_7_8","cal_7_9","cal_7_10","cal_7_11","cal_7_12","Q708_1","Q708_2","Q708_3","Q708_4","Q708_5","Q708_6","Q708_7",
			"Q708_8","Q708_9","Q708_10","Q708_11","Q708_12","Q709Week_1","Q709Week_2","Q709Week_3","Q709Week_4","Q709Week_5","Q709Week_6","Q709Week_7",
			"Q709Week_8","Q709Week_9","Q709Week_10","Q709Week_11","Q709Week_12","Q709Month_1","Q709Month_2","Q709Month_3","Q709Month_4","Q709Month_5",
			"Q709Month_6","Q709Month_7","Q709Month_8","Q709Month_9","Q709Month_10","Q709Month_11","Q709Month_12","Q709Year_1","Q709Year_2","Q709Year_3",
			"Q709Year_4","Q709Year_5","Q709Year_6","Q709Year_7","Q709Year_8","Q709Year_9","Q709Year_10","Q709Year_11","Q709Year_12").parse(in);

}
}
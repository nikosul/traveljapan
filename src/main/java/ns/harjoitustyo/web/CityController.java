package ns.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ns.harjoitustyo.domain.ActivitityRepository;
import ns.harjoitustyo.domain.City;
import ns.harjoitustyo.domain.CityRepository;

@Controller
public class CityController {
	
	@Autowired
	private CityRepository crepo;
	
	@Autowired
	private ActivitityRepository arepo;
	
	// mainpage // all cities
	@RequestMapping(value = "/home")
	public String cityList(Model model) {
		List<City> cities = (List<City>) crepo.findAll();
		model.addAttribute("cities", cities);
		return "citylist";
	}
	// activities according to a city
	@RequestMapping(value = "/activities/{cityId}", method = RequestMethod.GET)
	public String activitiesCity(@PathVariable("cityId") Long cityId, Model model) {
		model.addAttribute("city", crepo.findById(cityId));
		model.addAttribute("activities", arepo.findAll());
		return "activities";
	}
	
	// add a new city
	@RequestMapping(value = "/add")
	public String addCity(Model model) {
		model.addAttribute("city", new City());
		return "addcity";
	}
	
	// save the new city
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute City city) {
		crepo.save(city);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/edit/{cityId}")
	public String addCity(@PathVariable("cityId") Long cityId, Model model) {
		model.addAttribute("city", crepo.findById(cityId));
		model.addAttribute("activities", arepo.findAll());
		return "editcity";
	}
	
	@RequestMapping(value = "/delete/{cityId}", method = RequestMethod.GET)
	public String deleteCity(@PathVariable("cityId") Long cityId) {
		crepo.deleteById(cityId);
		return "redirect:../home";
}
	// comments page
	@RequestMapping(value = "/comments/{cityId}")
	public String commentCity(@PathVariable("cityId") Long cityId, Model model) {
		model.addAttribute("city", crepo.findById(cityId));
		return "comments";
	}
	
	// REST // get all cities
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public @ResponseBody List<City> getCitiesRest(){
		return (List<City>) crepo.findAll();
	}
	
	// REST // get 1 city
	@RequestMapping(value = "/city/{cityId}", method = RequestMethod.GET)
	public @ResponseBody Optional<City> findCityRest(@PathVariable("cityId") Long cityId){
		return crepo.findById(cityId);
	}
}
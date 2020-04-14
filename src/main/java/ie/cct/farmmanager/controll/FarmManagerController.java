package ie.cct.farmmanager.controll;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.farmmanager.model.Animal;
import ie.cct.farmmanager.view.MessageResponse;

/*
 * @author: Manoel Vitor Nascimento Lopes
 * @college: CCT College Dublin
 * @studentID: 2019286
 * */

@RestController
public class FarmManagerController {	
	//	Animals Values
	int cowsValue = 500;
	int pigsValue = 250;
	int chickensValue = 5;

	//	I have created 3 different Lists for each kind of animal
	List<Animal> cows = new LinkedList<Animal>();
	List<Animal> pigs = new LinkedList<Animal>();
	List<Animal> chickens = new LinkedList<Animal>();

	//	First end point to ADD a new ANIMAL!
	//	The parameters need to be passed by JSON
	@PostMapping("add-animal")
	public MessageResponse addAnimal(@RequestBody Animal animal) {
		if(animal.getType().equals("Cow") || animal.getType().equals("cow")) {
			cows.add(animal);
		}else if(animal.getType().equals("Pig") || animal.getType().equals("pig")) {
			pigs.add(animal);
		}else if(animal.getType().equals("Chicken") || animal.getType().equals("chicken")) {
			chickens.add(animal);
		}else {
			return new MessageResponse("Type of Animal: " + animal.getType() + " Incorrect, please check!");
		}

		//	Just for Debugging purposes, to check if the animals have been add to the correct arrayList
		//				System.out.println(cows.size());
		//				System.out.println(pigs.size());
		//				System.out.println(chickens.size());		

		return new MessageResponse("Animal: " + animal.getType() + 
				" Weight: " + animal.getWeight() + " Added Succesfully!");

	}

	//	Second end point to Check the Average Weight by Type of Animal!
	//	I Receive the parameter from the URL
	@GetMapping("calc-average")
	public MessageResponse calcAverage(@RequestParam(required = true)String type) {
		Double cowsAverageWeight = 0.0;
		Double pigsAverageWeight = 0.0;
		Double chickensAverageWeight = 0.0;


		//	If else statement to check if is a valid type
		//	if it is true will check all the animals by desired type and calculate the average
		if(type.equals("Cow") || type.equals("cow")) {
			try {
				for (Animal cow : cows) {
					cowsAverageWeight = cowsAverageWeight + cow.getWeight();
				}if(cowsAverageWeight == 0) {
					return new MessageResponse("There is no Cows to be calculated, please add some cows first!");
				}else {
					return new MessageResponse("Cows Average is: " + cowsAverageWeight / cows.size());
				}
			} catch (Exception e) {
				System.out.println("Sorry, Something went Wrong!");
			}
		}else if(type.equals("Pig") || type.equals("pig")) {
			try {
				for (Animal pig : pigs) {
					pigsAverageWeight = pigsAverageWeight + pig.getWeight();
				}if(pigsAverageWeight == 0) {
					return new MessageResponse("There is no Pigs to be calculated, please add some pigs first!");
				}else {
					return new MessageResponse("Pigs Average is: " + pigsAverageWeight / pigs.size());
				}
			} catch (Exception e) {
				System.out.println("Sorry, Something went Wrong!");
			}
		}else if(type.equals("Chicken") || type.equals("chicken")) {
			try {
				for (Animal chicken : chickens) {
					chickensAverageWeight = chickensAverageWeight + chicken.getWeight();
				}if(chickensAverageWeight == 0) {
					return new MessageResponse("There is no Chickens to be calculated, please add some chickens first!");
				}else {
					return new MessageResponse("Chickens Average is: " + chickensAverageWeight / chickens.size());
				}
			} catch (Exception e) {
				System.out.println("Sorry, Something went Wrong!");
			}
		}else {
			return new MessageResponse("Invalid type, please check! USE just (cow, pig OR chicken)");
		}


		return null;
	}


	//	Third end point to check how many animals of each type can be sold
	@GetMapping("to-sell")
	public MessageResponse toSell() {
		//	List to add animals ready to be sell
		List<Animal> cowsToSell = new LinkedList<Animal>();
		List<Animal> pigsToSell = new LinkedList<Animal>();
		List<Animal> chickensToSell = new LinkedList<Animal>();

		//	For each loop, to check the List of each animal created above
		//	If they are on the weight to be sold it is added to the Respective array of their type
		for(Animal cow: cows) {
			if(cow.getWeight() >= 300) {
				cowsToSell.add(cow);	
			}
		}

		for(Animal pig: pigs) {
			if(pig.getWeight() >= 100) {
				pigsToSell.add(pig);
			}
		}

		for(Animal chicken: chickens) {
			if(chicken.getWeight() >= 0.5) {
				chickensToSell.add(chicken);
			}
		}

		return new MessageResponse(cowsToSell.size() + " Cows Can be Sold " + pigsToSell.size() + " Pigs Can be Sold " + chickensToSell.size() + " Chickens Can be Sold");
	}

	//	Fourth end point to check the value of the full farm stock
	@GetMapping("stock-value")
	public MessageResponse stockValue() {
		Double farmStockValue = 0.0;

		//	List to add animals ready to be sell
		List<Animal> cowsToSell = new LinkedList<Animal>();
		List<Animal> pigsToSell = new LinkedList<Animal>();
		List<Animal> chickensToSell = new LinkedList<Animal>();


		//	For each loop, to check the List of each animal created above
		//	If they are on the weight to be sold it is added to the Respective array of their type
		for(Animal cow: cows) {
			if(cow.getWeight() >= 300) {
				cowsToSell.add(cow);	
			}
		}

		for(Animal pig: pigs) {
			if(pig.getWeight() >= 100) {
				pigsToSell.add(pig);
			}
		}

		for(Animal chicken: chickens) {
			if(chicken.getWeight() >= 0.5) {
				chickensToSell.add(chicken);
			}
		}

		if(cowsToSell.size() == 0 && pigsToSell.size() == 0 && chickensToSell.size() == 0) {
			return new MessageResponse("Sorry you do not have any animal ready to sell, please add at least one animal first");
		}else {
			farmStockValue = (double) ((cowsToSell.size() * cowsValue) + (pigsToSell.size() * pigsValue) + (chickensToSell.size() * chickensValue));
		}

		return new MessageResponse("Full Farm Stock is: € " + farmStockValue);
	}

	//	Fifth end point to check the value of the farm passing the values 
	//	by the HTTP request by the URL
	@GetMapping("current-value")
	public MessageResponse currentValue(@RequestParam(required = true)int cow, @RequestParam(required = true)int pig, @RequestParam(required = true)int chicken) {
		Double farmStockValue = 0.0;

		this.cowsValue = cow;
		this.pigsValue = pig;
		this.chickensValue = chicken;

		//	List to add animals ready to be sell
		List<Animal> cowsToSell = new LinkedList<Animal>();
		List<Animal> pigsToSell = new LinkedList<Animal>();
		List<Animal> chickensToSell = new LinkedList<Animal>();


		//	For each loop, to check the List of each animal created above
		//	If they are on the weight to be sold it is added to the Respective array of their type
		for(Animal co: cows) {
			if(co.getWeight() >= 300) {
				cowsToSell.add(co);	
			}
		}

		for(Animal pi: pigs) {
			if(pi.getWeight() >= 100) {
				pigsToSell.add(pi);
			}
		}

		for(Animal ch: chickens) {
			if(ch.getWeight() >= 0.5) {
				chickensToSell.add(ch);
			}
		}

		if(cowsToSell.size() == 0 && pigsToSell.size() == 0 && chickensToSell.size() == 0) {
			return new MessageResponse("Sorry you do not have any animal ready to sell, please add at least one animal first");
		}else {
			farmStockValue = (double) ((cowsToSell.size() * cowsValue) + (pigsToSell.size() * pigsValue) + (chickensToSell.size() * chickensValue));
		}


		return new MessageResponse("Farm Stock Value After prices updated is: € " + farmStockValue);
	}
}

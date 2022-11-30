# CCT College Dublin | Projects

# Farm Manager

Farm Manager is an Integrated Individual Practical Assignment of Cloud-Based Web Applications

# Assignment Introduction

> We want to develop a system to control the livestock of a farm. The system will allow us to
do some calculations around the benefits of the farm as well as get a summary of the current
stocking level of the same. The system will also need to be documented (word document or similar) up to a point that an
engineer on your similar skill level would be able to take over and develop new features.

# Specific Requirements 

The system will allow us to add new animals to the farm stock.

### The farm will only contain three types of animals: ###

- Cows
- Pigs
- Chickens

### Each animal has 2 attributes: ###

- Type
- Weight

### Each animal has a market value: ###

- Cows - €500
- Pigs - €250
- Chickens - €5

### The animals can only be sold if they reach a certain weight: ###

- Cows - 300 KG
- Pigs 100 KG
- Chickens - 0.5 KG


# The system that we are going to build need to have the necessary endpoints for the following operations:
- Add a new animal.
- Calculate the average weight of each type of animal (one endpoint is sufficient, no
need to build one per type of animal).
- How many animals of each type can be sold (weight requirements above) right now.
- What is the current value of the full farm stock: That is, the price of all the animals
that can be sold right now.
- What is the current value of the farm assuming the price of each animal is set by a
parameter in the HTTP request. This is an example:
- http://localhost:8080/currentValue?cow=350&pig=120&chicken=1

## Installation

Just clone the repository and import the project in your Favorite IDE such as Eclipse.

```bash
Gradle Based Project
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[CCT - Dublin](https://www.cct.ie/)

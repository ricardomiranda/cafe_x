# Cafe X

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The client wants you to build a billing system for their café till. Cafe X menu consists of the following items:
- Cola - Cold - 50p
- Coffee - Hot - £1.00
- Cheese Sandwich - Cold - £2.00
- Steak Sandwich - Hot - £4.50

Customers don’t know how much to tip and the staff rely on tips to survive.

## Task
### Step 1 : Standard Bill
Pass in a list of purchased items that produces a total bill.
For example `[“Cola”, “Coffee”, “Cheese Sandwich”]` returns 3.5

### Step 2: Service Charge
Add support for a service charge:
- When all purchased items are drinks no service charge is applied
- When purchased items include any food apply a service charge of 10% to the total bill (rounded to 2 decimal places)
- When purchased items include any hot food apply a service charge of 20% to the total bill with a maximum £20 service charge

## Run program
Clone the project to your machine.
Go to project folder.
Run instructions:

```bash
$ sbt assembly
$ docker build -f ./Dockerfile . -t cafe-x
$ docker run -v ~/cafe_x:/opt/app/cafe_x -it cafe-x
```

You will be asked what you want to purchase:
```bash
Insert name of item (press Enter to finish your purchase)?
```
Insert name of item. When you do not want any more items, press Enter with an empty line.

For example:
```bash
Insert name of item (press Enter to finish your purchase)?
$ Coffee
Insert name of item (press Enter to finish your purchase)?
$ Coffee
Insert name of item (press Enter to finish your purchase)?
$ Cola
Insert name of item (press Enter to finish your purchase)?
$
With items:
Cola
Coffee
Coffee
Price of items is 2.5
Service charge is 0.0
Total cost is 2.5
```

## Test program
To test the program do:

```bash
$ sbt test
```

## Requisites
You must have docker in your machine.

## Authors
*   [Ricardo Miranda](https://github.com/ricardomiranda)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

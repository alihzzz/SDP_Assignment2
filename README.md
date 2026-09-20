# Logistics Delivery Application

Assignment 2, Software Design Patterns. A console Java app that combines two patterns:
**Factory Method** creates the transport (`Truck` or `Ship`) and **Abstract Factory** creates a matching UI family (`Button` + `Checkbox`) for Windows or macOS.

## Packages

```
src/
├─ app/        Main (input, validation, selection), DeliveryApplication (client)
├─ logistics/  Transport, Truck, Ship, Logistics, RoadLogistics, SeaLogistics   (Factory Method)
└─ ui/         Button, Checkbox, GUIFactory, Windows*/MacOS* classes             (Abstract Factory)
docs/          UML diagrams
```

## Prerequisites

JDK 17 or newer. No external libraries.

## Build and run

```
mkdir -p out
javac --release 17 -d out $(find src -name '*.java')
java -cp out app.Main
```
The program asks for the delivery mode, then for the UI platform.

## Supported input (uppercase)

| Choice | Values |
|---|---|
| Delivery mode | `ROAD`, `SEA` |
| UI platform | `WINDOWS`, `MACOS` |

Unsupported, empty or missing input prints `Error: ...`, creates nothing and stops with exit code 1. There is no default value.

## Sample run

```
Delivery mode (ROAD or SEA): ROAD
UI platform (WINDOWS or MACOS): WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road
```

# Laboratory Equipment Management System

## License
This project is for educational purposes. Feel free to use and adapt the dataset for learning.

## Overview
A basic console‑based system developed in Java to manage laboratory equipment and user interactions. The project implements a full object‑oriented structure that supports multiple equipment types (Electronic, Container, Measurement), user management, equipment rental, validation rules and statistical analysis. It was built as part of the Programming Language course project.

## Objectives
This project implements a full management system that meets the academic requirements defined for the assignment of the course. The main objectives are:

- Apply Object‑Oriented Programming (OOP) concepts, including encapsulation, inheritance and class interaction.
- Build a dynamic equipment management system
- Implement three equipment categories: Electronic, Container, and Measurement
- Manage a predefined list of 15 users, each with name, birthdate and specialization
- Provide a menu-driven interface for user, using Scanner for all interactions
- Ensure input validation, preventing null or invalid data
- Generate statistics and general system information based on the equipment list
- Export equipment lists to text files, with or without full details

## Key Features
- Equipment Management: Create, edit, remove, search and list equipments. Supports three categories:
  - Electronic: power, energy consumption, operational constraints
  - Container: volume, material type, sterilization state
  - Measurement: measurement unit, current value, validation rules
- User Management: Preloaded list of 15 users with name, birthdate, and specialization
- Equipment Rental System: Assign and unassign equipment to users, ensuring availability rules
- Status Control: Manage equipment states (ACTIVE, MAINTENANCE, INACTIVE) with valid transitions
- Statistics Module: Total equipment per type, maintenance/active/inactive counts, lowest‑consumption electronic device, largest container, and average values for measurement equipment
- File Export: Generate text files with equipment lists (summary or full detail), ordered by ID
- Interactive Menu: Console interface using Scanner, providing all required operations



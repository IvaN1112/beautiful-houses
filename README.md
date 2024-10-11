# Beautiful House Detection in a Grid

## Description
This project implements a solution to detect "beautiful houses" in a 2D grid. A **beautiful house** is defined as a cluster of `1`s (representing houses) that satisfies the following conditions:
- The house is **completely surrounded by `0`s** (representing empty spaces) having in mind that **borders of the grid also are all surrounded by `0`s**.
- If any `1`s in the cluster are connected **diagonally**, they must also have a **horizontal or vertical neighbor** connecting them (no isolated diagonal connections).

The project utilizes **Depth-First Search (DFS)** with a stack to traverse the grid, check each house's connections, and ensure that it meets the conditions of a beautiful house.

## Features
- Traverses the grid to identify clusters of `1`s.
- Ensures that houses are surrounded by `0`s.
- Properly handles diagonal connections by ensuring they have valid horizontal/vertical connections.

## Usage
To run the project, clone the repository and compile the Java code. The main function demonstrates how to use the DFS to detect beautiful houses in a sample grid.

```bash
git clone https://github.com/yourusername/beautiful-house-detection.git
cd beautiful-house-detection
javac BeautifulHouses.java
java BeautifulHouses

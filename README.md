# Facade Design Pattern Implementation

## Overview

The **Facade Design Pattern** provides a simplified interface to a set of complex subsystems. This diagram illustrates a mining scenario where multiple workers (`DwarvenCartOperator`, `DwarvenGoldDigger`, `DwarvenTunnelDigger`) collaborate to dig gold, but their interactions are encapsulated and managed through a single interface: `DwarvenGoldmineFacade`.

This implementation abstracts the complex worker interactions into an easy-to-use interface for clients, simplifying the overall system.

![image](https://github.com/user-attachments/assets/1ee49fb4-189e-4988-a7c7-a81859297b79)

---

## Class Diagram Explanation

### **Core Classes**

1. **`DwarvenGoldmineFacade`**:
   - **Purpose**: Provides a unified interface for interacting with a team of dwarven workers.
   - **Attributes**:
     - `workers`: A list of `DwarvenMineWorker` objects representing the workers in the goldmine.
   - **Methods**:
     - `startNewDay()`: Wakes up the workers and starts their day.
     - `digOutGold()`: Orchestrates the mining process by instructing the workers to work.
     - `endDay()`: Sends workers home and concludes their day.
     - `makeActions(Collection<DwarvenMineWorker>, Action[])`: A helper method to perform a sequence of actions on the workers.

---

2. **`DwarvenMineWorker`** (Abstract Class):
   - **Purpose**: Represents a generic worker in the goldmine. Specific worker types inherit from this class.
   - **Attributes**:
     - `LOGGER`: Logs worker actions.
   - **Methods**:
     - `wakeUp()`: Wakes the worker up.
     - `goToMine()`: Sends the worker to the mine.
     - `goHome()`: Sends the worker home.
     - `goToSleep()`: Sends the worker to sleep.
     - `work()` (Abstract): Defines the work process for each worker.
     - `name()` (Abstract): Returns the worker's name.

---

3. **Worker Classes**:
   - **`DwarvenCartOperator`**:
     - Represents a worker who operates carts to transport gold.
     - Implements `name()` and `work()` methods specific to cart operations.

   - **`DwarvenGoldDigger`**:
     - Represents a worker who digs for gold.
     - Implements `name()` and `work()` methods specific to gold digging.

   - **`DwarvenTunnelDigger`**:
     - Represents a worker who digs tunnels in the goldmine.
     - Implements `name()` and `work()` methods specific to tunnel digging.

---

4. **`App`**:
   - **Purpose**: The main entry point of the program.
   - **Methods**:
     - `main(String[] args)`: Demonstrates the use of `DwarvenGoldmineFacade` to interact with the workers and execute mining operations.

---

5. **`Action`** (Enum):
   - **Purpose**: Represents the possible actions that workers can perform.
   - **Values**:
     - `WAKE_UP`, `GO_TO_MINE`, `WORK`, `GO_HOME`, `GO_TO_SLEEP`.
   - **Methods**:
     - `valueOf(String name)`: Returns an `Action` by its name.
     - `values()`: Returns all possible actions.

---

### **Relationships**

1. **`DwarvenGoldmineFacade` and `DwarvenMineWorker`**:
   - The `DwarvenGoldmineFacade` maintains a list of `DwarvenMineWorker` objects and delegates tasks to them.

2. **`DwarvenMineWorker` and `Action`**:
   - Each worker performs actions defined by the `Action` enum.

3. **Inheritance**:
   - `DwarvenCartOperator`, `DwarvenGoldDigger`, and `DwarvenTunnelDigger` inherit from the `DwarvenMineWorker` abstract class, implementing the `work()` and `name()` methods specific to their tasks.

---

## How It Works

1. **Simplified Interface**:
   - The `DwarvenGoldmineFacade` simplifies interaction with the complex subsystem of dwarven workers by providing high-level methods like `startNewDay()`, `digOutGold()`, and `endDay()`.

2. **Worker Coordination**:
   - The facade orchestrates the workflow by coordinating the actions of individual workers, ensuring all required tasks are executed in order.

3. **Example Usage**:
   ```java
   public class App {
       public static void main(String[] args) {
           DwarvenGoldmineFacade goldmine = new DwarvenGoldmineFacade();
           goldmine.startNewDay();
           goldmine.digOutGold();
           goldmine.endDay();
       }
   }
   ```

   **Output**:
   ```
   Dwarven Gold Digger wakes up.
   Dwarven Tunnel Digger wakes up.
   Dwarven Cart Operator wakes up.
   ...
   Dwarven Gold Digger works hard digging for gold.
   Dwarven Tunnel Digger digs out a tunnel.
   Dwarven Cart Operator moves gold chunks out of the mine.
   ...
   ```

---

## Advantages of Using the Facade Pattern

- **Simplifies Client Interaction**: Hides the complexity of multiple subsystems behind a unified interface.
- **Reduces Coupling**: The client only interacts with the facade, not with individual subsystems.
- **Improves Code Maintainability**: Changes to worker classes or actions do not affect the client.

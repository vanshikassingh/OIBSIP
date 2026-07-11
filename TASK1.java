# -------------------------------
# ONLINE RESERVATION SYSTEM
# -------------------------------

# Login Details
USERNAME = "admin"
PASSWORD = "1234"

# Store Reservations
reservations = {}

# Train Data
trains = {
    "101": "Rajdhani Express",
    "102": "Shatabdi Express",
    "103": "Duronto Express"
}

print("===== ONLINE RESERVATION SYSTEM =====")

# ---------------- LOGIN ----------------
user = input("Enter Username: ")
pwd = input("Enter Password: ")

if user != USERNAME or pwd != PASSWORD:
    print("Invalid Login!")
    exit()

print("\nLogin Successful!")

while True:

    print("\n------ MENU ------")
    print("1. Reservation")
    print("2. Cancellation")
    print("3. Exit")

    choice = input("Enter Choice: ")

    # -------- RESERVATION --------
    if choice == "1":

        pnr = input("Enter PNR Number: ")
        name = input("Passenger Name: ")

        train_no = input("Train Number (101/102/103): ")

        if train_no in trains:
            train_name = trains[train_no]
        else:
            train_name = "Unknown Train"

        class_type = input("Class (Sleeper/AC): ")
        journey_date = input("Journey Date: ")
        source = input("From: ")
        destination = input("To: ")

        reservations[pnr] = {
            "Name": name,
            "Train No": train_no,
            "Train Name": train_name,
            "Class": class_type,
            "Date": journey_date,
            "From": source,
            "To": destination
        }

        print("\nReservation Successful!")
        print("PNR:", pnr)

    # -------- CANCELLATION --------
    elif choice == "2":

        pnr = input("Enter PNR Number: ")

        if pnr in reservations:

            print("\nReservation Details")
            for key, value in reservations[pnr].items():
                print(key, ":", value)

            confirm = input("Cancel Ticket? (Y/N): ")

            if confirm.upper() == "Y":
                del reservations[pnr]
                print("Ticket Cancelled Successfully.")
            else:
                print("Cancellation Cancelled.")

        else:
            print("PNR Not Found.")

    # -------- EXIT --------
    elif choice == "3":
        print("Thank You!")
        break

    else:
        print("Invalid Choice.")

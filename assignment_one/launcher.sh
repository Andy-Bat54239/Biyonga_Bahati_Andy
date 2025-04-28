#!/bin/bash

echo "Which question do you want to run?"
echo "1) Question 1"
echo "2) Question 2"
echo "3) Question 3"
read -p "Enter 1, 2 or 3: " choice

case "$choice" in
  1)
    echo "Running Question 1..."
    java -cp out casestudy.question1.Main
    ;;
  2)
    echo "Running Question 2..."
    java -cp out casestudy.question2.Main
    ;;
  3)
    echo "Running Question 3..."
    java -cp out casestudy.question3.Main
    ;;
  *)
    echo "Invalid choice. Exiting."
    exit 1
    ;;
esac

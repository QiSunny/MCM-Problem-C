#!/usr/bin/python

import csv
import sys

def get_data_list_of_dicts(filename):
  list = []
  with open(filename) as f:
    f_csv = csv.DictReader(f)
    for row in f_csv:
      list.append(row)
  return list

def is_synthetic(substance):
    if not (substance == "Buprenorphine" or substance == "Codeine" or substance == "Heroin" or substance == "Hydrocodone" or substance == "Hydromorphone" or substance == "Hydrocodeinone" or substance == "Morphine" or substance == "Opiate" or substance == "Opium" or substance == "Oxycodone" or substance == "Oxymorphone" or substance == "Thebaine"):
        return True
    else:
        return False

def get_heroin(list_of_dicts):
  drug = {}
  for dict in list_of_dicts:
    state = dict["State"]
    year = dict["YYYY"]
    county = dict["COUNTY"]
    substance = dict["SubstanceName"]
    drug_report = dict["DrugReports"]
    if state == "KY" and year == "2010" and substance == "Heroin":
      drug[county].append(drug_report)
  return drug

def get_synthetic(list_of_dicts):
    drug = {}
    for dict in list_of_dicts:
        state = dict["State"]
        year = dict["YYYY"]
        county = dict["COUNTY"]
        substance = dict["SubstanceName"]
        drug_report = dict["DrugReports"]
        if state == "KY" and year == "2010" and is_synthetic(substance) == True:
            drug[county].append(drug_report)
    return drug

def write_heroin_to_file(list_of_dicts, f):
    heroin = get_heroin(list_of_dicts)
    f = open(filename, 'w')
    f.write("Heroin\t" + str(len(heroin)) + "\n")
    for drug in heroin:
        towrite = drug + "\t"
        for number in heroin[drug]:
            towrite = towrite + number + " "
        towrite = towrite + "\n"
    f.write(towrite)

def write_synthetic_to_file(list_of_dicts, f):
    synthetic = get_synthetic(list_of_dicts)
    f = open(filename, 'w')
    f.write("Synthetic\t" + str(len(synthetic)) + "\n")
    for drug in synthetic:
        towrite = drug + "\t"
        for number in synthetic[drug]:
            towrite = towrite + number + " "
        towrite = towrite + "\n"
    f.write(towrite)

def write_drugs_to_file(list_of_dicts, filename):
  f = open(filename, 'w')
  write_heroin_to_file(list_of_dicts, f)
  write_synthetic_to_file(list_of_dicts, f)
  f.close()

if len(sys.argv) != 2:
  print ("Usage: " + sys.argv[0] + " <MCM_NFLIS_Data.csv> <Heroin.txt> <Synthetic.txt>")
  exit(1)
list_of_dicts = get_data_list_of_dicts(sys.argv[1])
write_heroin_to_file(list_of_dicts, sys.argv[2])
write_synthetic_to_file(list_of_dicts, sys.argv[3])

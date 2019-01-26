#!/usr/bin/python

import csv
import sys

def get_data_list_of_dicts(filename):
  list = []
  with open(filename) as f:
    f_csv = csv.DictReader(f)
    for row in f_csv:
      #print(row)
      list.append(row)
  return list

def is_synthetic(substance):
    if not (substance == "Buprenorphine" or substance == "Codeine" or substance == "Heroin" or substance == "Hydrocodone" or substance == "Hydromorphone" or substance == "Hydrocodeinone" or substance == "Morphine" or substance == "Opiate" or substance == "Opium" or substance == "Oxycodone" or substance == "Oxymorphone" or substance == "Thebaine"):
        return True
    else:
        return False

def get_synthetic(list_of_dicts, YYYY):
    drug_dict = {}
    drug_dict["KY"] = {}
    drug_dict["VA"] = {}
    drug_dict["WV"] = {}
    drug_dict["PA"] = {}
    drug_dict["OH"] = {}
    for dict in list_of_dicts:
        state = dict["State"]
        year = dict["\xef\xbb\xbfYYYY"]
        county = dict["COUNTY"]
        substance = dict["SubstanceName"]
        drug_report = dict["DrugReports"]
        #for key in drug_dict.keys():
        if year == str(YYYY) and is_synthetic(substance) == True:
            if county not in drug_dict[state].keys():
                drug_dict[state][county] = []
                drug_dict[state][county].append(drug_report)
            else:
                drug_dict[state][county].append(drug_report)
        # if state == "VA" and year == str(YYYY) and is_synthetic(substance) == True:
        #     if county not in drugVA.keys():
        #         drugVA[county] = []
        #         drugVA[county].append(drug_report)
        #     else:
        #         drugVA[county].append(drug_report)
        # if state == "WV" and year == str(YYYY) and is_synthetic(substance) == True:
        #     if county not in drugWV.keys():
        #         drugWV[county] = []
        #         drugWV[county].append(drug_report)
        #     else:
        #         drugWV[county].append(drug_report)
        # if state == "PA" and year == str(YYYY) and is_synthetic(substance) == True:
        #     if county not in drugPA.keys():
        #         drugPA[county] = []
        #         drugPA[county].append(drug_report)
        #     else:
        #         drugPA[county].append(drug_report)
        # if state == "OH" and year == str(YYYY) and is_synthetic(substance) == True:
        #     if county not in drugOH.keys():
        #         drugOH[county] = []
        #         drugOH[county].append(drug_report)
        #     else:
        #         drugOH[county].append(drug_report)
    return drug_dict

def write_synthetic_to_file(list_of_dicts, file10, file11, file12, file13, file14, file15, file16, file17):
    drug_dict = get_synthetic(list_of_dicts, 2010)
    #print(drug_dict)
    f10 = open(file10, 'w')
    f10.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f10.write(state + "\t" + county + "\t" + str(total) + "\n")
    f10.close()

    drug_dict = get_synthetic(list_of_dicts, 2011)
    #print(drug_dict)
    f11 = open(file11, 'w')
    f11.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f11.write(state + "\t" + county + "\t" + str(total) + "\n")
    f11.close()

    drug_dict = get_synthetic(list_of_dicts, 2012)
    #print(drug_dict)
    f12 = open(file12, 'w')
    f12.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f12.write(state + "\t" + county + "\t" + str(total) + "\n")
    f12.close()

    drug_dict = get_synthetic(list_of_dicts, 2013)
    #print(drug_dict)
    f13 = open(file13, 'w')
    f13.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f13.write(state + "\t" + county + "\t" + str(total) + "\n")
    f13.close()

    drug_dict = get_synthetic(list_of_dicts, 2014)
    #print(drug_dict)
    f14 = open(file14, 'w')
    f14.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f14.write(state + "\t" + county + "\t" + str(total) + "\n")
    f14.close()

    drug_dict = get_synthetic(list_of_dicts, 2015)
    #print(drug_dict)
    f15 = open(file15, 'w')
    f15.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f15.write(state + "\t" + county + "\t" + str(total) + "\n")
    f15.close()

    drug_dict = get_synthetic(list_of_dicts, 2016)
    #print(drug_dict)
    f16 = open(file16, 'w')
    f16.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f16.write(state + "\t" + county + "\t" + str(total) + "\n")
    f16.close()

    drug_dict = get_synthetic(list_of_dicts, 2017)
    #print(drug_dict)
    f17 = open(file17, 'w')
    f17.write("State\t" + "County\t" + "Number of Synthetics Reports\n")
    for state in drug_dict.keys():
        for county in drug_dict[state].keys():
            total = 0
            for case in drug_dict[state][county]:
                case_int = int(case)
                total += case_int
            f17.write(state + "\t" + county + "\t" + str(total) + "\n")
    f17.close()

def write_drugs_to_file(list_of_dicts, filename):
  f = open(filename, 'w')
  write_synthetic_to_file(list_of_dicts, f)
  f.close()

if len(sys.argv) != 11:
  print ("Usage: " + sys.argv[0] +
  "<MCM_NFLIS_Data.csv> <Heroin.txt> <Synthetic10.txt> <Synthetic11.txt> <Synthetic12.txt> <Synthetic13.txt> <Synthetic14.txt> <Synthetic15.txt> <Synthetic16.txt> <Synthetic17.txt>")
  exit(1)
list_of_dicts = get_data_list_of_dicts(sys.argv[1])
#print(list_of_dicts)
#print(type(list_of_dicts))
#write_heroin_to_file(list_of_dicts, sys.argv[2])
write_synthetic_to_file(list_of_dicts, sys.argv[3], sys.argv[4], sys.argv[5], sys.argv[6], sys.argv[7]
, sys.argv[8], sys.argv[9], sys.argv[10])

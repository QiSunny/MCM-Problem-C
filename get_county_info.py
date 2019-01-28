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

def get_synthetic(nflis_dicts, household_dicts):
    drug_dict = {}
    drug_dict["KY"] = {}
    drug_dict["VA"] = {}
    drug_dict["WV"] = {}
    drug_dict["PA"] = {}
    drug_dict["OH"] = {}
    fips_dict = {}
    for dict in list_of_dicts:
        state = dict["State"]
        year = dict["\xef\xbb\xbfYYYY"]
        county = dict["COUNTY"]
        code = dict["FIPS_Combined"]
        substance = dict["SubstanceName"]
        drug_report = dict["DrugReports"]
        if substance == "Heroin":
            if county not in drug_dict[state].keys():
                drug_dict[state][county] = []
                drug_dict[state][county].append(drug_report)
                for dicts in household_dicts:
                    print(household_dicts)
                    codes = dict["Id2"]
                    fips_dict[codes] = {}
                    if codes == code:
                        i = 0
                        for names in fips_dict.keys():
                            name = str(names) + str(i)
                            i += 1
                            name = dict[names]
                            drug_dict[state][county].append(name)
            else:
                drug_dict[state][county].append(drug_report)
    return drug_dict

def write_synthetic_to_file(list_of_dicts, file10, file11, file12, file13, file14, file15, file16, file17):
    drug_dict = get_synthetic(list_of_dicts, 2010)
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

def write_drugs_to_file(list_of_dicts, filename):
  f = open(filename, 'w')
  write_synthetic_to_file(list_of_dicts, f)
  f.close()

def write_info_to_file(list_of_dicts, household_dicts, filename):
    drug_dict = get_synthetic(list_of_dicts, household_dicts)
    print(drug_dict)
    f = open(filename, 'w')
    f.write("State\t" + "County\t" + "Number of Synthetics Reports\t" + "Other Necessary Info\n")
    #for state in drug_dict.keys():
    #    for county in drug_dict[state].keys():
    f.close()


if len(sys.argv) != 4:
  print ("Usage: " + sys.argv[0] +
  " <MCM_NFLIS_Data.csv> <ACS_10_5YR_DP02_with_ann.csv> <result.txt>")
  exit(1)
list_of_dicts = get_data_list_of_dicts(sys.argv[1])
household_dicts = get_data_list_of_dicts(sys.argv[2])
#print(list_of_dicts)
#print(type(list_of_dicts))
#write_heroin_to_file(list_of_dicts, sys.argv[2])
#write_synthetic_to_file(list_of_dicts, sys.argv[3], sys.argv[4], sys.argv[5], sys.argv[6], sys.argv[7]
#, sys.argv[8], sys.argv[9], sys.argv[10])
write_info_to_file(list_of_dicts, household_dicts, sys.argv[3])

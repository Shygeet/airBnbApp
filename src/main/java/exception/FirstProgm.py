import phonenumbers
from phonenumbers import geocoder
from phonenumbers import carrier
import folium
import os
from opencage.geocoder import OpenCageGeocode

# number = input("Enter the phone number with country code : ")
# phoneNumber = phonenumbers.parse(number)
# geolocation = geocoder.description_for_number(phoneNumber,"en")
# print("location : "+geolocation)

m1 = "Hi"
m2 = 'abc'
print(f'{m1}{m2}')
print(f"type prints data type of input  {type(m1)}")

print("upper prints data uppercase of input " + m1.upper()+' '+m2)

# List operations
demoList = [1, 2, 3, 'one']
print(f"List is : {demoList}")
print(demoList[:2])
for l in demoList:
    print(l)

newListSorted = demoList.sort
print(newListSorted)

myDict = {'Name': 'ABC', 'Mob': 8750328420}
print(myDict.keys())
for key, value in myDict.items():
    print(key)
    print(value)

    def sum_dictvalues(a, b) :
        x = a + b
        return x

    print(sum_dictvalues(2, 3))



    for i in range(2, 10, 3):
        print(i)

print(os.getcwd())
print(os.listdir())



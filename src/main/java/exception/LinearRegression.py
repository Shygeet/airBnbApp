import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as seabornInstance
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.tree import DecisionTreeClassifier



import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as seabornInstance
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

input_file = pd.read_csv('C:\\Users\\shivanshut.sw\\Downloads\\music.csv')
print(input_file.head(3))
input_file['User_Rating'] = input_file['age'] * .5
print(input_file.head(3))
randaom_rating = np.random.randint(2, 1000, size=input_file.__len__())
input_file['Rand_Rating'] = randaom_rating
print(input_file.head(3))

series1 = pd.Series(randaom_rating, index=np.arange(0, input_file.__len__()))
input_file = input_file.assign(Assigned_column=series1)
input_file.insert(0, 'SNO', np.random.randint(3, 1000, size=input_file.__len__()))
input_file.rename(columns={'age': 'AGE', 'genre': 'GENRE'}, inplace=True)
print(input_file.sort_values('SNO', ascending=False, key=lambda col: col > 40))
# inplace = true



print(input_file['GENRE'].value_counts())

input_file = input_file.set_index('GENRE')
print(input_file)

print(input_file.loc[['HipHop', 'Jazz'], 'User_Rating':'Assigned_column'])

# print(input_file.head().genre)
# print(input_file.info)
# print(input_file[['age', 'gender']])
# X = input_file.drop(columns=['genre'])
# print(X)
# Y = input_file['genre']
# print(Y)
#
# model = DecisionTreeClassifier()
#
# X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2)
#
# model.fit(X_train, Y_train)
# prediction = model.predict(X_test)
# print(prediction)
#
# score = accuracy_score(Y_test, prediction)
# print(score)

data = np.array([[1, 2], [2, 3]])
print(data)
# creating a datframe
df = pd.DataFrame(data, columns=['col1', 'col2'], index=['row1', 'row2'])
print(df)

Sector = ['sec79', 'sec78', 'sec7x']
No_of_Towers = [12, 10, 25]

dictofLists = {'Sec': Sector, 'Towers': No_of_Towers}
dfofdictofLists = pd.DataFrame(dictofLists)
print(dfofdictofLists)
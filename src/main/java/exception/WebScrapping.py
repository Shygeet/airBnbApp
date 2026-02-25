import pandas as pd
import numpy as np

df_premiere = pd.read_csv('https://www.football-data.co.uk/mmz4281/2526/E0.csv')
print(df_premiere.head(3))
df_premiere.rename(columns={'AvgCAHA': 'Goal'}, inplace=True)
print(df_premiere.head(10))
print(df_premiere[df_premiere['HomeTeam'] == 'Liverpool'].value_counts('HomeTeam'))
# isin aslo can be use for filter ring in above query

df_premiere['Performance'] = np.where(df_premiere['Goal'] > 2, 'Excellent', 'Avg')
print(df_premiere)

condition = [(df_premiere['Goal'] > 2) & (df_premiere['BFECAHH']) > 2, df_premiere['Goal'] > 2]
value = ['+++', '++']

df_premiere['Rating'] = np.select(condition, value)
print(df_premiere)


duplicate = df_premiere.duplicated('HomeTeam')
print(df_premiere[duplicate][['HomeTeam', 'Goal']])

df_highest = df_premiere.sort_values(['HomeTeam', 'Goal']).drop_duplicates(['HomeTeam'], keep='last')
try:
   print(df_highest[df_highest['HomeTeam'], df_highest['Goal']])
except Exception as e:
    print("Exception occured")

print(df_premiere['HomeTeam'].nunique())

base_address = 'https://www.football-data.co.uk/mmz4281/'

leagues = ['E0', 'E1']
Excel_List_From_WebPage = []

for league in leagues:
    for season in range(20, 25):
        df = pd.read_csv(base_address + str(season) + str(season+1) + '/' + league + '.csv')
        df.insert(1, 'Season', season)
        Excel_List_From_WebPage.append(df)
# for i in range(len(Excel_List_From_WebPage)-1):
#     # print(len(Excel_List_From_WebPage))
#     print(Excel_List_From_WebPage[0].head(10))


print
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# cricket_data = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Swayam Py Course\week3\IPL_Players_20.csv",index_col = 'Player')
cricket_data = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Swayam Py Course\week3\IPL_Players_20.csv")
print(cricket_data)

cricket_data.rename(columns = {'Runs.1':'Runs_delivered'}, inplace = True)
print(cricket_data.columns)

print(cricket_data.info())

print(cricket_data.loc[0:5])
record1 = cricket_data.loc[0:4,['Player','100']]
print(record1)
# iloc()is similar to loc() but it uses integer based indexing to access specific rows and columns.
# The iloc() function takes two arguments: the row indices and column indices to be selected.
print(cricket_data.iloc[0:5,0:4])

print(cricket_data[cricket_data['6s'] > 25])
print(cricket_data.query("Bat_SR> 200"))

print(cricket_data.sort_values(['Mat','Runs']))
cricket_data.sort_values(['Mat', 'Runs'], ascending=[True, False])

# This will output a dictionary where the keys are tuples representing the 100('s, '
# 'and the values are arrays of integers representing the indices of the rows in the original DataFrame that belong to that group.)

print(cricket_data.groupby('100')['Runs'].max())

player_stats = cricket_data.groupby('100').agg({
    'Runs': 'sum',
    '50': 'sum',
})

print(player_stats)

player_stats = cricket_data.groupby(['100','50']).agg({
    'Runs': 'sum',
    '6s': 'sum',
}).reset_index()
print(player_stats)
# Set index to half-century
player_stats.set_index('50', inplace=True)
print(player_stats)


# Create sample DataFrames
df1 = pd.DataFrame({'Player': ['SuryaKumar Yadav', 'Rohit Sharma', 'Jasprit Bumrah'],
                    'Team': ['MI', 'MI', 'MI'],
                    'Runs': [11867, 9115,0 ],
                   'Wickets': [0,0,97]})

df2 = pd.DataFrame({'Player': ['Virat Kohli', 'Faf Duplesis', 'Maxwell'],
                    'Team': ['RCB', 'RCB', 'RCB'],
                    'Runs': [10115, 9115, 10767]})

df3 = pd.DataFrame({'Player': ['Ashwin', 'Siraj', 'Varun Chakravarthy'],
                    'Team': ['RR', 'RCB', 'England'],
                    'Wickets': [101, 91, 107]})

# Concat the DataFrames
concated_df = pd.concat([df1,df2,df3])
print(concated_df)

data1 = pd.DataFrame({'Player': ['MS Dhoni', 'Rahane', 'Ruturaj Gaikwad'],
                    'Team': ['CSK', 'CSK', 'CSK'],
                    'Runs': [11867, 9115, 27]})


data2 = pd.DataFrame({'Players': ['MS Dhoni', 'Rahane', 'Kohli'],
                    'Team': ['CSK', 'CSK', 'RCB'],
                    'Average': [59.33, 48.55, 54.17]})
merged_df = pd.merge(data1, data2 , how='inner', left_on=['Player'], right_on=['Players'])
print(merged_df)


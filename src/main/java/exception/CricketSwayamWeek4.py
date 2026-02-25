import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns




data = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Swayam Py Course\week4\virat_kohli_ball_by_ball_2022.csv")

duplicate = data[data.duplicated()]

print(duplicate)

# Filter the data to include only the deliveries where Virat Kohli scored 4 / 6 runs
fours = data[data['batsman_run']==4]

print(f"Total number of fours:{len(fours)}")

sixes = data.query("batsman_run == 6")

print(f"Total number of sixes:{len(sixes)}")

extras = data['extra_type'].value_counts()

print(extras)

total_balls_faced = len(data['extra_type']) - (data['extra_type']=='wides').sum()

print("Total balls faced by virat kohli:",total_balls_faced)


total_runs = data['batsman_run'].sum()

strike_rate = (total_runs/total_balls_faced) * 100

print(f"Strike rate:{strike_rate:.2f}")

# How many times Virat got out
times_out = data[data['player_out'] == 'V Kohli']['isWicketDelivery'].sum()

print("Number of times Virat Kohli got out:", times_out)


most_common_over = data[data['player_out'] == 'V Kohli']['overs'].value_counts().idxmax()

print("Most common over at which Virat Kohli got out:", most_common_over)

#Which kind he was out most of the times
common_kind = data[data['player_out'] == 'V Kohli']['kind'].value_counts()

percent_common_kind = []
for j in common_kind.values:
    percentage_kind = (j/times_out)*100
    percent_common_kind.append(percentage_kind)

print(f"Virat Kohli got out {percent_common_kind[0]:.2f}% by {common_kind.idxmax()} out.")



# phases of the innings
powerplay_overs = range(0, 7)
middle_overs = range(7, 16)
death_overs = range(16, 21)

# Create a new column 'innings_phase' to identify the phase of each delivery
def categorize_innings_phase(overs):
    if overs in powerplay_overs:
        return 'Powerplay'
    elif overs in middle_overs:
        return 'Middle Overs'
    elif overs in death_overs:
        return 'Death Overs'
    else:
        return 'Other'

data['innings_phase'] = data['overs'].apply(categorize_innings_phase)

# Group the data by 'innings_phase'
phase_group = data.groupby('innings_phase')


# Calculate various batting performance metrics for each phase
phase_stats = phase_group.agg({
    'total_run': 'sum',
    'batsman_run': 'sum',
    'ballnumber': 'count'
})

# Calculate strike rate for each phase
phase_stats['strike_rate'] = (phase_stats['batsman_run'] / phase_stats['ballnumber']) * 100

# Display the results
print(phase_stats)


powerplay_df = data[data['overs'].isin(powerplay_overs)]
# Calculate various batting performance metrics for each phase
powerplay_stats = powerplay_df.agg({
    'total_run': 'sum',
    'batsman_run': 'sum',
    'ballnumber': 'count'
})
powerplay_stats['strike_rate'] = (powerplay_stats['batsman_run'] / powerplay_stats['ballnumber']) * 100
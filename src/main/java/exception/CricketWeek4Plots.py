import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# cricket_data = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Swayam Py Course\week3\IPL_Players_20.csv",index_col = 'Player')
cricket_data = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Syam Py\week3\IPL_Players_20.csv")
print(cricket_data.head())

data_2022 = cricket_data.head()

#Bar plot of players strike_rate
plt.bar(data_2022['Player'],data_2022['Bat_SR'],color='red',width = 0.2)

# Set x-axis for better visualization
plt.xticks(rotation = 'vertical',fontsize = 10)

# Set title to the plot
plt.title('Strike Rate of Players')

plt.show()

# Calculate the x-coordinates for the bars
bar_width = 0.3
x = np.arange(len(data_2022['Player']))

# Plot the bars side by side
plt.bar(x - bar_width/2,data_2022['50'], color='r', width=bar_width, label='Half Centuries')
plt.bar(x,data_2022['Mat'], color='g', width=bar_width, label='Matches')
plt.bar(x + bar_width/2,data_2022['100'], color='b', width=bar_width, label='Centuries')

# Set the labels for both the axis
plt.xlabel("Player")
plt.ylabel("Milestones")
# Set x-axis for better visualization
plt.xticks(x,data_2022['Player'])
plt.xticks(rotation = 'vertical',fontsize = 10)
plt.legend(["Half Centuries", "Matches",  "Centuries"])
# Set title to the plot
plt.title("Scores by Players")
plt.show()


# Create a subplot with 1 row and 2 columns
# Plotting first plot
plt.subplot(1,2,1)
plt.bar(data_2022['Player'],data_2022['Bat_Avg'],color='maroon',width = 0.2)
plt.xticks(rotation = 'vertical',fontsize = 10)
# Set title for the 1st subplot
plt.title('Batting Average of Players')

# Plotting second plot
plt.subplot(1,2,2)
plt.bar(data_2022['Player'],data_2022['Bat_SR'],color='red',width = 0.2)
plt.xticks(rotation = 'vertical',fontsize = 10)
# Set title for the 2nd subplot
plt.title('Strike Rate of Players')

# Set super title for both the plots
plt.suptitle('IPL stats of Batsman')
plt.show()
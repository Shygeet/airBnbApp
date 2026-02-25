import matplotlib.pyplot as plt
import numpy as np

Devices = ['Android','Appple','TV','Others']
Numbers = [20,10,30,5]
All = sum(Numbers)

plt.plot(Devices, Numbers,All)

plt.title(f"Sum of all devices = {All}")
plt.show()
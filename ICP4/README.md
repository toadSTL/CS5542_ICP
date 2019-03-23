# ICP 4

### Objectives

  1. Train CNN Model Using Different Optimizers and compare (leaving other configurations the same)
  2. Reconfigure CNN and retrain model using filter size 16, 36, 128
  3. Show Tensorboard results

### Implementation

As shown in the below image, the intial training using the Adam Optimizer gives training accuracy of 96% and test accuracy of 94.5% after 400 steps.
![Code and output](/doc/icp4-1.png)
The highlighted 'AdamOptimizer' function is what we must change to change the algorithm.  A list of available optimizers can be gathered from the tensorflow documentation: https://www.tensorflow.org/api_docs/python/tf/train/

In order to change the optimizer we simply change that function, i.e.:

Change this:
```sh
train_step = tf.train.AdamOptimizer(1e-4).minimize(cross_entropy)
```
to this:
```sh
train_step = tf.train.AdadeltaOptimizer(1e-4).minimize(cross_entropy)
```

Initially tested Adadelta, Adagrad, Adam, Gradient Decent, Proximal Adagrad, Proximal Gradient Decent, and RMSProp.  The cross entropy graphs resulting from these trainings are shown below.

![Various Optimizers Cross-Entropy](ICP4/doc/icp4-2.png)

Here we can see that Adam and RMSProp perform substantially better than the other Optimizers, with Adadelta standing out as the worst performing optimizer.

Initially we are using filter sizes 32 and 64 for our convolutional layers.  In order to reconfigure so that we are using filter sizes 16, 36, and 128, we need to add an addtional convolutional layer, and update the sizes.  This essnetially entails changing this:
```sh
W_conv1 = weight_variable([5, 5, 1, 32])
b_conv1 = bias_variable([32])
x_image = tf.reshape(x, [-1, 28, 28, 1])
h_conv1 = tf.nn.relu(conv2d(x_image, W_conv1) + b_conv1)
h_pool1 = max_pool_2x2(h_conv1)

W_conv2 = weight_variable([5, 5, 32, 64])
b_conv2 = bias_variable([64])
h_conv2 = tf.nn.relu(conv2d(h_pool1, W_conv2) + b_conv2)
h_pool2 = max_pool_2x2(h_conv2)

W_fc1 = weight_variable([7 * 7 * 64, 1024])
b_fc1 = bias_variable([1024])

h_pool2_flat = tf.reshape(h_pool2, [-1, 7 * 7 * 64])
```
to this:
```sh
W_conv1 = weight_variable([5, 5, 1, 16])
b_conv1 = bias_variable([16])
x_image = tf.reshape(x, [-1, 28, 28, 1])
h_conv1 = tf.nn.relu(conv2d(x_image, W_conv1) + b_conv1)
h_pool1 = max_pool_2x2(h_conv1)

W_conv2 = weight_variable([5, 5, 16, 36])
b_conv2 = bias_variable([36])
h_conv2 = tf.nn.relu(conv2d(h_pool1, W_conv2) + b_conv2)
h_pool2 = max_pool_2x2(h_conv2)

W_conv3 = weight_variable([5, 5, 36, 128])
b_conv3 = bias_variable([128])
h_conv3 = tf.nn.relu(conv2d(h_pool2, W_conv3) + b_conv3)
h_pool3 = max_pool_2x2(h_conv3)

W_fc1 = weight_variable([4 * 4 * 128, 1024])
b_fc1 = bias_variable([1024])

h_pool2_flat = tf.reshape(h_pool3, [-1, 4 * 4 * 128])
```

Using this configuration for the CNN, I retrained models using the Adam, Adagrad, Proximal Gradient Decent, and RMSProp optimizers.  The cross-entropy graphs for these modles are shown below: 

![Selected Optimizers Cross-Entropy Reconfigured CNN](ICP4/doc/icp4-3.png)

Notably, again RMSProp and Adam perform the best.


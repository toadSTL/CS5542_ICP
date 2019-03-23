# ICP 6

### Objectives



### Implementation

Initially we trained an LSTM using the provided sample data belling_the_cat.txt

After training the LSTM on this sample data, we are shown the Loss and Accuracy and are allowed to test it by providing a predefined number of words and allowing the LSTM to generate words.  Below is a screenshot of this output:

![Initial LSTM training](https://github.com/toadSTL/CS5542_ICP/blob/master/ICP6/doc/screenshot1.png)

After training the LSTM model using the questions as the input (which required re-formatting the questions so that all are on a single line and sepapated by periods) the LSTM accuracy ended up being 0.27%.
```sh
Iter= 1000, Average Loss= 5.970296, Average Accuracy= 0.10%
['dark', 'vases', 'where', 'two'] - [of] vs [what]
Iter= 2000, Average Loss= 5.492666, Average Accuracy= 0.19%
['in', 'the', 'air', 'in'] - [front] vs [the]
Iter= 3000, Average Loss= 4.948606, Average Accuracy= 0.26%
['flowers', 'sitting', 'on', 'a'] - [table] vs [vase]
Iter= 4000, Average Loss= 5.256208, Average Accuracy= 0.21%
['bed', 'with', 'a', 'zebra'] - [print] vs [next]
Iter= 5000, Average Loss= 5.169926, Average Accuracy= 0.21%
['walkway.', 'what', 'stands', 'alone'] - [in] vs [the]
Iter= 6000, Average Loss= 4.911331, Average Accuracy= 0.24%
['flowers', 'in', 'a', 'vase'] - [picture.] vs [of]
Iter= 7000, Average Loss= 4.861362, Average Accuracy= 0.25%
['what', 'filled', 'with', 'purple'] - [flowers] vs [on]
Iter= 8000, Average Loss= 4.888672, Average Accuracy= 0.27%
['yellow.', 'what', 'is', 'the'] - [color] vs [color]
Optimization Finished!
Elapsed time:  1.5726086576779683 min
Run on command line.
4 words: how many people are
how many people are what is the color of the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple.
4 words: what color is the
what color is the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple. what is the color of the
4 words: what streches its neck
Word not in dictionary
4 words: what stretches it 's neck
4 words: what stretches it 's
what stretches it 's the is the color of the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple. what is the color of the flowers purple.
```

This is especially odd as it also seems to have overfit the data, and in my testing of it, it would alway repeat the same guess sequence.



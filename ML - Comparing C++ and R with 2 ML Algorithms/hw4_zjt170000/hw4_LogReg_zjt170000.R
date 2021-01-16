# Homework 4 - Zachary Tarell
# Logistic Regression model on plasma data

library(HSAUR)
data(plasma)
i <- sample(1:nrow(plasma), nrow(plasma), replace=FALSE)
train <- plasma[i,]
glm1 <- glm(formula=ESR~fibrinogen, data=train, family=binomial)
glm1$coefficients

# Start Time
startscratch <- proc.time()

# function to return a vector of sigmoid values from an input matrix
sigmoid <- function(z){
  1.0 / (1+exp(-z))
}

# set up weight vector, label vector, and data matrix
weights <- c(1, 1)
data_matrix <- cbind(rep(1, nrow(train)), train$fibrinogen)
labels <- as.integer(train$ESR) - 1
weights <- c(1, 1)  # repeat this for rerunning the block
learning_rate <- 0.001
for (i in 1:500000){
  prob_vector <- sigmoid(data_matrix %*% weights)
  error <- labels - prob_vector
  weights <- weights + learning_rate * t(data_matrix) %*% error
}

# End time
endscratch <- proc.time()
weights

# Total system time
totTime <- endscratch - startscratch
print(paste("The total time of Logistic Regression from Scratch is: ", totTime))

# 2 plots
plot(plasma$ESR~plasma$fibrinogen)
cdplot(plasma$ESR~plasma$fibrinogen)

# Data exploration to equal 4 total
summary(glm1)
names(glm1)
head(glm1)
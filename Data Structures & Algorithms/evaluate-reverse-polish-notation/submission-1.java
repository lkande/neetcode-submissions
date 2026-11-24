class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException(
                "Expected an initial operand followed by operand–operator pairs"
            );
        }

        int i = 0;
        List<Integer> stack = new ArrayList<>();
        Set<String> operators = Set.of("*", "-", "+", "/");
        while (i < tokens.length) {
            if(operators.contains(tokens[i])){
                if (stack.size() >= 2) {
                    int result = performOp(stack.remove(stack.size()-1), stack.remove(stack.size()-1), tokens[i++]);
                    stack.add(result);
                } else {
                    throw new IllegalArgumentException(
                        "Expected an initial operand followed by operand–operator pairs"
                    );
                }

            } else {
                stack.add(Integer.parseInt(tokens[i++]));
            }
        }
        return stack.get(0);
    }

    int performOp(int operand, int result, String operator) {
        switch (operator) {
            case "+":
                result = add(result, operand);
                break;
            case "-":
                result = subtract(result, operand);
                break;
            case "/":
                result = division(result, operand);
                break;
            case "*":
                result = multiplication(result, operand);
                break;
            default:
                throw new IllegalArgumentException(
                    "Unknown operator: " + operator
                );
        }

        return result;
    }
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int division(int a, int b) {
        return a / b;
    }

    int multiplication(int a, int b) {
        return a * b;
    }
}

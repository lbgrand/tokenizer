import { useState } from 'react';

function Validator() {
    const [toValidateToken, setToValidateToken] = useState("");
    const [validationResult, setValidationResult] = useState("");

    function validateToken() {
        fetch(`http://localhost:2000/validate/${toValidateToken}`, { method: 'GET' })
            .then(response => {
                if (!response.ok) {
                    throw new Error();
                }
                return response.text()
            })
            .then(body => setValidationResult(body === "true" ? "Valid" : "Invalid"))
            .catch(error => setValidationResult("ERROR - Invalid input provided"));
    }

    function handleToValidateToken(event) {
        setToValidateToken(event.target.value);
    }

    return (
        <div>
            <p>Validate a token</p>
            <input type="text" value={toValidateToken} onChange={handleToValidateToken} />
            <input type="button" value="Validate" onClick={validateToken} />
            <p>Result: {validationResult}</p>
        </div>
    );
}

export default Validator;

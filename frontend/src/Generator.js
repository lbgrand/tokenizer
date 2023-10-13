import { useState } from 'react';

function Generator() {
    const [token, setToken] = useState("");
    const [digits, setDigits] = useState([]);

    function generateToken() {
        fetch('http://localhost:1000/token', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(digits)
        })
            .then(response => response.text())
            .then(body => setToken(body));
    }

    function handleCheckboxChange(event) {
        if (event.target.checked) {
            digits.push(parseInt(event.target.value))
            setDigits(digits);
        } else {
            setDigits(digits.filter(digit => digit != event.target.value));
        }
    }

    return (
        <div>
            <p>Generate a token</p>
            <input type="text" value={token} readOnly />
            <div>
                {[0, 1, 2, 3, 4, 5, 6, 7, 8, 9].map(digit => (
                    <span>
                        <label> {digit}: </label>
                        <input key={digit} onClick={handleCheckboxChange} value={digit} type="checkbox" />
                    </span>
                ))}
            </div>
            <input type="button" value="Generate" onClick={generateToken} />
        </div>
    );
}

export default Generator;

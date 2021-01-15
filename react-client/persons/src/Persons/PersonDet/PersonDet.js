import React, { Component } from 'react';
import './PersonDet.css';

class PersonDet extends Component {
    render() {

        return (
            <div className="PersonDet">
                <p>Person id: {this.props.person.id}</p>
                <p>First Name: {this.props.person.firstName}</p>
                <p>Last Name: {this.props.person.lastName}</p>
                <p>Birth date: {this.props.person.birthDate}</p>
                <p>Salary: {this.props.person.salary}</p>
                <button onClick={this.props.deleteHandler}>Delete</button>
            </div>
        );
    }
}

export default PersonDet;
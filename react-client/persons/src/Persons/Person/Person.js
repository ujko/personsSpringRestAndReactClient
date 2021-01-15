import React, { Component } from 'react';
import './Person.css'

class Person extends Component {
    render() {
        return (
            <div className="Person" onClick={this.props.showDetailsHandler}>
                <p>{this.props.firstName} {this.props.lastName}</p>
            </div>
        );
    }
}

export default Person;
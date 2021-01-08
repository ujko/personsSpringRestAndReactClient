import React, { Component } from 'react';
import Person from './Person/Person';
import './Persons.css'

class Persons extends Component {
    render() {
        const persons = this.props.persons.map((person, index) => {
            return <Person id={person.id} firstName={person.firstName} 
            lastName={person.lastName} birthDate={person.birthDate} 
            salary={person.salary} key={person.id} click={() => this.props.showDetailsHandler(person.id)}/>
        });
        return (
            <div className="Persons">
                {persons}
            </div>
        );
    }
}

export default Persons;
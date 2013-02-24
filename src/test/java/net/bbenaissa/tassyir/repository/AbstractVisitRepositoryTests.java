/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.bbenaissa.tassyir.repository;

import net.bbenaissa.tassyir.model.Pet;
import net.bbenaissa.tassyir.model.Visit;
import net.bbenaissa.tassyir.repository.OwnerRepository;
import net.bbenaissa.tassyir.repository.PetRepository;
import net.bbenaissa.tassyir.repository.VisitRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * <p> Base class for {@link OwnerRepository} integration tests. </p>
 * <p/>
 * see javadoc inside {@link AbstractVetRepositoryTests} for more details
 *
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public abstract class AbstractVisitRepositoryTests {

    @Autowired
    protected VisitRepository visitRepository;

    @Autowired
    protected PetRepository petRepository;


    @Test
    @Transactional
    public void insertVisit() {
        Pet pet7 = this.petRepository.findById(7);
        int found = pet7.getVisits().size();
        Visit visit = new Visit();
        pet7.addVisit(visit);
        visit.setDescription("test");
        // both storeVisit and storePet are necessary to cover all ORM tools
        this.visitRepository.save(visit);
        this.petRepository.save(pet7);
        pet7 = this.petRepository.findById(7);
        assertEquals(found + 1, pet7.getVisits().size());
    }

}
